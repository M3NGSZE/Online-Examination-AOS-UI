package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response

data class ApiErrorResponse(
    val timestamp: String,
    val status: Int,
    val error: String?,
    val message: String?,
    val path: String?,
    val errors: Map<String, String>? = emptyMap()
)
