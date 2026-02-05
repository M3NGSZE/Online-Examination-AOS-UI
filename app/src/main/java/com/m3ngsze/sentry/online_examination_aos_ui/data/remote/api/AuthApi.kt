package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.AuthRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auths/login")
    suspend fun login(
        @Body request: AuthRequest
    ): AuthDTO
}