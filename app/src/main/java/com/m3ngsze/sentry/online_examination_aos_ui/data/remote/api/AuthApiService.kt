package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.UserDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.AuthRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.OtpRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthApiService {
    @POST("auths/login")
    suspend fun login(
        @Body request: AuthRequest
    ): ApiResponse<AuthDTO>

    @POST("auths/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): ApiResponse<UserDTO>

    @POST("auths/verify-otp")
    suspend fun verifyOtp(
        @Body request: OtpRequest
    ): ApiResponse<Boolean>

    @POST("auths/resend-otp")
    suspend fun sendOtp(
        @Query("email") email: String?
    ): ApiResponse<Boolean>

}