package com.m3ngsze.sentry.online_examination_aos_ui.domain.model

import java.util.UUID

data class Task(
    val examId: UUID,
    val title: String,
    val due: String?,
    val status: String
)