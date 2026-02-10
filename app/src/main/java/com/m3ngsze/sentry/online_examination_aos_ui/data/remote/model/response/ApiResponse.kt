package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response

data class ApiResponse <T> (
    val message: String,
    val status: String,
    val requestedTime: String,
    val payload: T
)
