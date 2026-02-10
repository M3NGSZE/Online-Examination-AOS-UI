package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import android.util.Patterns
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.safeApiCall
import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository,
    private val sessionManager: SessionManager
) {

    private val passwordRegex =
        Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")

    suspend fun login(
        email: String,
        password: String
    ): AppResult<Auth>{
        if (!email.contains("@")) return AppResult.Error("Invalid email format")
        if (password.isBlank()) return AppResult.Error("Password is required")

        return safeApiCall {
            val login = repository.login(email, password)

            sessionManager.saveAuthToken(login.accessToken)

            login
        }
    }

    suspend fun register(request: RegisterRequest): AppResult<User> {

        if (request.firstName.isBlank()) return AppResult.Error("First name is required")
        if (request.lastName.isBlank()) return AppResult.Error("Last name is required")

        if (!Patterns.EMAIL_ADDRESS.matcher(request.email).matches())
            return AppResult.Error("Invalid email format")
        if (!passwordRegex.matches(request.password))
            return AppResult.Error("Password must be at least 8 characters long and include 1 uppercase letter, 1 number, and 1 special character")

        return safeApiCall {
            val user = repository.register(request)

            // OTP sending is optional; failure won't block registration
            try {
                repository.sendOtp(request.email)
            } catch (e: Exception) {
                println("OTP sending failed: ${e.message}")
            }

            user
        }
    }

    suspend fun verifyOtp(email: String?, otp: String): AppResult<Boolean>{
        email?.contains("@")?.let { if (!it) return AppResult.Error("Invalid email format") }
        if (otp.isBlank()) return AppResult.Error("Password is required")

        return safeApiCall { repository.verifyOtp(email, otp) }
    }

    suspend fun sendOtp(email: String?): AppResult<Boolean>{
        email?.contains("@")?.let { if (!it) return AppResult.Error("Invalid email format") }

        return safeApiCall { repository.sendOtp(email) }
    }

}