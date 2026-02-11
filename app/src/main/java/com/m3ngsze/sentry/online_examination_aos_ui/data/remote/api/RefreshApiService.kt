package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ApiResponse
import retrofit2.http.POST
import retrofit2.http.Query

interface RefreshApiService {
    @POST("auths/refresh-token")
    suspend fun refreshToken(
        @Query("refreshToken") refreshToken: String?
    ): ApiResponse<AuthDTO>
}