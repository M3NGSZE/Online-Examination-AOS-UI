package com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase

import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.safeApiCall
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ListResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.ListDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Room
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.RoomRepository
import javax.inject.Inject

class RoomUseCase @Inject constructor(
    private val repository: RoomRepository
){
    suspend fun getAllUserRooms(page: Int, size: Int, search: String?, sort: String?, room: String?): AppResult<ListDTO<Room>> {
        return safeApiCall { repository.getAllUserRooms(page, size, search, sort, room) }
    }
}