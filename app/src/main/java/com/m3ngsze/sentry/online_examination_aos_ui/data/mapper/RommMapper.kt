package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.RoomDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room

fun RoomDTO.toDomain(): Room{
    return Room(
        roomId = roomId,
        roomName = roomName,
        userId = userId,
        firstName = firstName,
        lastname = lastname,
        section = section,
        subject = subject,
        student = student,
        limit = limit,
        isDeleted = isDeleted
    )
}