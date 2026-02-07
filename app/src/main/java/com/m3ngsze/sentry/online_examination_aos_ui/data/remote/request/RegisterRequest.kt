package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request

import java.time.LocalDate

data class RegisterRequest(
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String,

    val dateOfBirth: LocalDate? = null,
    val placeOfBirth: String? = null,
    val phoneNumber: String? = null,
    val profileUrl: String? = null
)
