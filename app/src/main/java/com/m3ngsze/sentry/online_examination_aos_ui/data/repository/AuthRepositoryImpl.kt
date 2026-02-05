package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApiService
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.AuthRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
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

        if (response.status != 200)
            throw Exception(response.message)

        return response.payload.toDomain()
    }

}