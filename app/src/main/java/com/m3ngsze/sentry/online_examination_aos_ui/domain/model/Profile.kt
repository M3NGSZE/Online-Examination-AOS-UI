package com.m3ngsze.sentry.online_examination_aos_ui.domain.model

import java.util.UUID

data class Profile(
    val userId: UUID,
    val firstName: String,
    val lastName: String,
    val profileUrl: String?,
)