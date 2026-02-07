package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto.UserDTO
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User

fun UserDTO.toDomain(): User{
    return User(
        userId = userId,
        email = email,
        accountStatus = accountStatus,
        firstName = firstName,
        lastName = lastName,

        dateOfBirth = dateOfBirth,
        placeOfBirth = placeOfBirth,
        phoneNumber = phoneNumber,
        profileUrl = profileUrl,
    )
}