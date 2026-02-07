package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.UserDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.AuthRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("/api/v1/auths/login")
    suspend fun login(
        @Body request: AuthRequest
    ): ApiResponse<AuthDTO>

    @POST("/api/v1/auths/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): ApiResponse<UserDTO>
}