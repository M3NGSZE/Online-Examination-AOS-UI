package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto.RoomDTO
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface RoomApiService {
    @GET("rooms")
    suspend fun getAllUserRooms(
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("search") search: String?,
        @Query("sort") sort: String?,
        @Query("room") room: String?,
    ) : ApiResponse<RoomDTO>
}