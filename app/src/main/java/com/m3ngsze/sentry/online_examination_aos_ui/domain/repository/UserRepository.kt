package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User

interface UserRepository {
    suspend fun getUserProfile(): User
}