package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    private val passwordRegex =
        Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")

    suspend fun login(
        email: String,
        password: String
    ): Auth{
        if (!email.contains("@")) throw IllegalArgumentException("Invalid email format")
        if (password.isBlank()) throw IllegalArgumentException("Password is required")

        return  repository.login(email, password)
    }

    suspend fun register(request: RegisterRequest): User {

        if (request.firstName.isBlank()) throw IllegalArgumentException("First name is required")
        if (request.lastName.isBlank()) throw IllegalArgumentException("Last name is required")

        if (!request.email.contains("@")) throw IllegalArgumentException("Invalid email format")
        if (!passwordRegex.matches(request.password))
            throw IllegalArgumentException("Password must be at least 8 characters long and include 1 uppercase letter, 1 number, and 1 special character")

        return repository.register(request)
    }

    suspend fun verifyOtp(email: String, otp: String): Boolean{
        if (!email.contains("@")) throw IllegalArgumentException("Invalid email format")
        if (otp.isBlank()) throw IllegalArgumentException("Password is required")

        return repository.verifyOtp(email, otp)
    }
}