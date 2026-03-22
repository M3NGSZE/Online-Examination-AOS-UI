package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.RoomApiService
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.RoomRepository
import javax.inject.Inject

class RoomRepositoryImpl @Inject constructor(
    private val api: RoomApiService
) : RoomRepository {
    override suspend fun getAllUserRooms(page: Int, size: Int, search: String?, sort: String?, room: String?): Room {
        val response = api.getAllUserRooms(page, size, search, sort, room)

        if (response.status != "200 OK")
            throw Exception(response.message)

        return response.payload.toDomain();
    }
}