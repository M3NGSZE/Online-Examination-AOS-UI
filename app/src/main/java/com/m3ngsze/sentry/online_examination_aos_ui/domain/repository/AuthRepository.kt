package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth

interface AuthRepository {
    suspend fun login(email: String, password: String): Auth
}