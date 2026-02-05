package com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response

data class PaginationResponse(
    val totalItems: Long,
    val totalPages: Int,
    val currentPage: Int,
    val pageSize: Int,

    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean,

    val nextPage: Int?,
    val previousPage: Int?,
    val firstPage: Int?,
    val lastPage: Int?
)
