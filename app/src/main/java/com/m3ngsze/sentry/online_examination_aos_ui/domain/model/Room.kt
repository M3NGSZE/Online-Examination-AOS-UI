package com.m3ngsze.sentry.online_examination_aos_ui.domain.model

import java.util.UUID

data class Room(
    val roomId: UUID?,
    val roomName: String?,
    val userId: UUID?,
    val firstName: String?,
    val lastname: String?,
    val section: String?,
    val subject: String?,
    val student: Int?,
    val limit: Int?,
    val isDeleted: Boolean?
)
