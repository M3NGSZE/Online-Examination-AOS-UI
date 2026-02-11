package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.RefreshApiService
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.RefreshTokenRepository
import javax.inject.Inject

class RefreshTokenRepositoryImpl @Inject constructor(
    private val api: RefreshApiService
): RefreshTokenRepository {
    override suspend fun refreshToken(refreshToken: String): Auth {
        val response = api.refreshToken(refreshToken)

        if (response.status != "200 OK")
            throw Exception(response.message)

        return response.payload.toDomain()
    }
}