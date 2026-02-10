package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto

data class AuthDTO(
    val accessToken: String,
    val refreshToken: String,
    val expiresIn: Long,
    val role: String
)
