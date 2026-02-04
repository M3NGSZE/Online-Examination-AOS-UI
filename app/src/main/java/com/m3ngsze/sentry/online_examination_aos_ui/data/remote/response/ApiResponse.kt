package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response

data class ApiResponse <T> (
    val message: String,
    val status: Int,
    val requestedTime: String,
    val payload: T
)
