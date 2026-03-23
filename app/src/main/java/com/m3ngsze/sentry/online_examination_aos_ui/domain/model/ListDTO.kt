package com.m3ngsze.sentry.online_examination_aos_ui.domain.model


data class ListDTO <T>(
    val data: List<T>,
    val pagination: Pagination
)