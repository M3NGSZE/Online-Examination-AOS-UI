package com.m3ngsze.sentry.online_examination_aos_ui.domain.repository

import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.ListDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room

interface RoomRepository {
    suspend fun getAllUserRooms(page: Int, size: Int, search: String?, sort: String?, room: String?) : ListDTO<Room>
}