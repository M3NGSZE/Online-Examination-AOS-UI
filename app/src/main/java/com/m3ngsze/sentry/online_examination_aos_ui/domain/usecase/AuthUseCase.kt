package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    suspend fun login(
        email: String,
        password: String
    ): Auth{
        return  repository.login(email, password)
    }

    suspend fun register(request: RegisterRequest): User = repository.register(request)
}