package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.core.network.RetrofitClient
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.AuthApi
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response.ApiResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {

    private val api = RetrofitClient.retrofit.create(AuthApi::class.java)

    override suspend fun login(
        email: String,
        password: String
    ): ApiResponse<AuthDTO> {
        TODO("Not yet implemented")
    }

}