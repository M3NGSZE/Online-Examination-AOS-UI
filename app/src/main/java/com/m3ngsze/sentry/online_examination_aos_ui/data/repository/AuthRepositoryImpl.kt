package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.AuthRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.OtpRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
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

        return response.payload.toDomain()
    }

    override suspend fun verifyOtp(email: String, otp: String): Boolean {
        val response = api.verifyOtp(OtpRequest(email, otp))

        if (response.status != "201 CREATED")
            throw Exception(response.message)

        return true
    }

}