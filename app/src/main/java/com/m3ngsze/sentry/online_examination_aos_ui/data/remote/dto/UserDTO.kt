package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.dto

import java.time.LocalDate
import java.util.UUID

data class UserDTO(
    val userId: UUID?,
    val email: String?,
    val accountStatus: String?,
    val firstName: String?,
    val lastName: String?,

    val dateOfBirth: LocalDate?,
    val placeOfBirth: String?,
    val phoneNumber: String?,
    val profileUrl: String?,
) : BaseDTO()
