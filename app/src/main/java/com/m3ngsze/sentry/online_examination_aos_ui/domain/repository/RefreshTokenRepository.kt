package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth

interface RefreshTokenRepository {
    suspend fun refreshToken(refreshToken: String): Auth
}