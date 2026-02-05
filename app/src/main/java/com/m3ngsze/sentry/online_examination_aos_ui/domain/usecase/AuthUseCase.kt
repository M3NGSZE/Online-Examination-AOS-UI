package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository

class AuthUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(
        email: String,
        password: String
    ): Auth{
        return  repository.login(email, password)
    }
}