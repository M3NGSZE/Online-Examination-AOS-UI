package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import android.util.Log
import com.google.gson.Gson
import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.AuthRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.OtpRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApiService
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String
    ): Auth {

        val response = api.login(AuthRequest(email, password))

        if (response.status != "200 OK")
            throw Exception(response.message)

        return response.payload.toDomain()
    }

    override suspend fun register(request: RegisterRequest): User {
        val response = api.register(request)

        if (response.status != "201 CREATED")
            throw Exception(response.message)

        Log.d("API_RESPONSE", Gson().toJson(response.payload))


        return response.payload.toDomain()
    }

    override suspend fun verifyOtp(email: String?, otp: String): Boolean {
        val response = api.verifyOtp(OtpRequest(email, otp))

        if (response.status != "200 OK")
            throw Exception(response.message)

        return true
    }

    override suspend fun sendOtp(email: String?): Boolean {
        val response = api.sendOtp(email)

        if (response.status != "200 OK")
            throw Exception(response.message)

        return true
    }

    override suspend fun logout(refreshToken: String): Boolean {
        Log.d("authRepo1", "Token: $refreshToken")

        val response = api.logout(refreshToken.trim())

        Log.d("authRepo2", "Status: ${response.status}")
        Log.d("authRepo3", "Message: ${response.message}")

        if (response.status != "200 OK") {
            throw Exception(response.message)
        }

        return true
    }

}