package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response.ApiResponse

interface AuthRepository {
    suspend fun login(email: String, password: String): ApiResponse<AuthDTO>
}