package com.m3ngsze.sentry.online_examination_aos_ui.data.mapper

import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.PaginationResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Pagination


fun PaginationResponse.toDomain() : Pagination {
    return Pagination(
//        totalItems = totalItems,
//        totalPages = totalPages,
//        currentPage = currentPage,
//        pageSize = pageSize,
//
//        hasNextPage = hasNextPage,
//        hasPreviousPage = hasPreviousPage,
//
//        nextPage = nextPage,
//        previousPage = previousPage,
//        firstPage = firstPage,
//        lastPage = lastPage,

        currentPage = currentPage,
        hasNextPage = hasNextPage
    )
}