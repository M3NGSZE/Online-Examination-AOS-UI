package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.interceptor

import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(
    private val sessionManager: SessionManager
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val token = runBlocking {
            sessionManager.getAccessToken()
        }

        val request = chain.request().newBuilder()

        token?.let {
            request.addHeader(
                "Authorization",
                "Bearer $it"
            )
        }

        return chain.proceed(request.build())
    }
}
