package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import com.google.gson.Gson
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response.ApiErrorResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import retrofit2.HttpException
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    private val passwordRegex =
        Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{8,}$")

    suspend fun login(
        email: String,
        password: String
    ): AppResult<Auth>{
        if (!email.contains("@")) return AppResult.Error("Invalid email format")
        if (password.isBlank()) return AppResult.Error("Password is required")

        return try {
            val auth = repository.login(email, password)
            AppResult.Success(auth)
        } catch (e: HttpException) {
            val errorJson = e.response()?.errorBody()?.string()
            val message = try {
                val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                apiError.message
            } catch (_: Exception) {
                "Server error"
            }
            AppResult.Error(message)
        } catch (e: Exception) {
            AppResult.Error("Unexpected error: ${e.message}")
        }
    }

    suspend fun register(request: RegisterRequest): AppResult<User> {

        if (request.firstName.isBlank()) return AppResult.Error("First name is required")
        if (request.lastName.isBlank()) return AppResult.Error("Last name is required")

        if (!request.email.contains("@")) return AppResult.Error("Invalid email format")
        if (!passwordRegex.matches(request.password))
            return AppResult.Error("Password must be at least 8 characters long and include 1 uppercase letter, 1 number, and 1 special character")

        return try {
            val user = repository.register(request)
            AppResult.Success(user)
        } catch (e: HttpException) {
            val errorJson = e.response()?.errorBody()?.string()
            val message = try {
                val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                apiError.message
            } catch (_: Exception) {
                "Server error"
            }
            AppResult.Error(message)
        } catch (e: Exception) {
            AppResult.Error("Unexpected error: ${e.message}")
        }
    }

    suspend fun verifyOtp(email: String?, otp: String): AppResult<Boolean>{
        email?.contains("@")?.let { if (!it) return AppResult.Error("Invalid email format") }
        if (otp.isBlank()) return AppResult.Error("Password is required")

        return try {
            val verify = repository.verifyOtp(email, otp)
            AppResult.Success(verify)
        } catch (e: HttpException) {
            val errorJson = e.response()?.errorBody()?.string()
            val message = try {
                val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                apiError.message
            } catch (_: Exception) {
                "Server error"
            }
            AppResult.Error(message)
        } catch (e: Exception) {
            AppResult.Error("Unexpected error: ${e.message}")
        }
    }
}