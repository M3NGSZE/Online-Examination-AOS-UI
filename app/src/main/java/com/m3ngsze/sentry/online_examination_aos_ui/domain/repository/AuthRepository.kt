package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): Auth

    suspend fun register(request: RegisterRequest): User

    suspend fun verifyOtp(email: String?, otp: String): Boolean

    suspend fun sendOtp(email: String?): Boolean
}