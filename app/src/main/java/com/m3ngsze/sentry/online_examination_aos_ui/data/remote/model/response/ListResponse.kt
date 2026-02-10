package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response

data class ListResponse <T>(
    val data: T,
    val pagination: PaginationResponse
)
