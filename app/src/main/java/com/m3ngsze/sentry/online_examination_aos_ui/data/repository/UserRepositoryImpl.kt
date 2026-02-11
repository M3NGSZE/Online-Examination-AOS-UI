package com.m3ngsze.sentry.online_examination_aos_ui.data.repository

import com.m3ngsze.sentry.online_examination_aos_ui.data.mapper.toDomain
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.api.UserApiService
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val api: UserApiService
): UserRepository {

    override suspend fun getUserProfile(): User {
        val response =  api.getUserProfile()
        if (response.status != "200 OK")
            throw Exception(response.message)

        return response.payload.toDomain()
    }

}