package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.RoomDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ListResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.ListDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room

fun ListResponse<RoomDTO>.toDomain(): ListDTO<Room> {
    return ListDTO(
        data = data.map { it.toDomain() },
        pagination = pagination.toDomain()
    )
}