package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.interceptor

import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.RefreshTokenRepository
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(
    private val sessionManager: SessionManager,
    private val repository: RefreshTokenRepository
) : Authenticator {

    // Endpoints that should NOT trigger refresh
    private val skipEndpoints = listOf(
        "/auths/login",
        "/auths/register",
        "/auths/refresh-token",
        "/auths/verify-otp",
        "/auths/resend-otp",
        "/auths/forgot-password",
        "/auths/oauth2/google"
    )

    override fun authenticate(
        route: Route?,
        response: Response
    ): Request? {

        //  Skip refresh for non-auth endpoints
        val path = response.request.url.encodedPath
        val shouldSkip = skipEndpoints.any { path.contains(it) }

        if (shouldSkip) return null

        // Prevent infinite loop
        if (responseCount(response) >= 2) {
            return null
        }

        val refreshToken = runBlocking {
            sessionManager.getRefreshToken()
        } ?: return null

        return try {

            // 🔄 Call refresh API
            val newAuth = runBlocking {
                repository.refreshToken(refreshToken)
            }

            // 💾 Save new tokens
            runBlocking {
                sessionManager.saveTokens(
                    newAuth.accessToken,
                    newAuth.refreshToken
                )
            }

            // 🔁 Retry original request with new token
            response.request.newBuilder()
                .header(
                    "Authorization",
                    "Bearer ${newAuth.accessToken}"
                )
                .build()

        } catch (e: Exception) {

            //  Refresh failed → clear session
            runBlocking {
                sessionManager.clearSession()
            }

            null
        }
    }

    private fun responseCount(response: Response): Int {
        var count = 1
        var prior = response.priorResponse

        while (prior != null) {
            count++
            prior = prior.priorResponse
        }
        return count
    }
}
