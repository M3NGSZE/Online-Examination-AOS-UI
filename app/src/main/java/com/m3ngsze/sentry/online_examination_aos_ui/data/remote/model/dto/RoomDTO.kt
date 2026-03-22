package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto

import java.util.UUID

data class RoomDTO (
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