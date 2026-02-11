package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.UserDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ApiResponse
import retrofit2.http.GET

interface UserApiService {
    @GET("/user-profile")
    suspend fun getUserProfile() : ApiResponse<UserDTO>
}