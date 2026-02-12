package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.interceptor

import android.util.Log
import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {

    // List of endpoints that DON'T require token
    private val skipEndpoints = listOf(
        "/auths/login",
        "/auths/register",
        "/auths/refresh-token",
        "/auths/verify-otp",
        "/auths/resend-otp",
        "/auths/forgot-password",
        "/auths/oauth2/google"
    )

    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()

        val path = originalRequest.url.encodedPath

        // Check if request should skip token

        val shouldSkip = skipEndpoints.any { path.endsWith(it) }

        Log.d("path", "encodedPath = $path")
        Log.d("shouldSkip", "$shouldSkip")

        if (!shouldSkip) {
            val token = runBlocking {
                sessionManager.getAccessToken().also { Log.d("token", "$it") }
            }

            token?.let {
                requestBuilder.addHeader(
                    "Authorization",
                    "Bearer $it"
                )
            }
        }

        return chain.proceed(requestBuilder.build())
    }
}
