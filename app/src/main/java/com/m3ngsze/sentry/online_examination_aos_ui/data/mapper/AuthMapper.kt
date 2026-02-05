package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.AuthDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth

fun AuthDTO.toDomain(): Auth {
    return Auth(
        accessToken = accessToken,
        refreshToken = refreshToken,
        expiresIn = expiresIn,
        role = role
    )
}
