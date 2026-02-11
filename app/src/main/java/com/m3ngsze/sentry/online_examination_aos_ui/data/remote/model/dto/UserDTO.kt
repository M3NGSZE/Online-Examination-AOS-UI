package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.dto

import java.util.UUID

data class UserDTO(
    val userId: UUID?,
    val email: String?,
    val accountStatus: String?,
    val firstName: String?,
    val lastName: String?,

    val dateOfBirth: String?,
    val placeOfBirth: String?,
    val phoneNumber: String?,
    val profileUrl: String?,
) : BaseDTO()
