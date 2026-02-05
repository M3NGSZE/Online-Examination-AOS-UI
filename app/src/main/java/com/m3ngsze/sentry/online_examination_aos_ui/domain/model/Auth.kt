package com.m3ngsze.sentry.online_examination_aos_ui.domain.model

data class Auth(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long,
    val role: String
)
