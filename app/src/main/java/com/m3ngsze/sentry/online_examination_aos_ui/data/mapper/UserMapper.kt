package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.UserDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import java.util.UUID

fun UserDTO.toDomain(): User{
    return User(
        userId = userId ?: UUID.randomUUID(),
        email = email.orEmpty(),
        accountStatus = accountStatus.orEmpty(),
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        dateOfBirth = dateOfBirth,
        placeOfBirth = placeOfBirth,
        phoneNumber = phoneNumber,
        profileUrl = profileUrl
    )
}