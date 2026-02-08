package com.m3ngsze.sentry.online_examination_aos_ui.core.constants

sealed class AppResult<out T> {
    data class Success<out T>(val data: T): AppResult<T>()
    data class Error(val message: String?): AppResult<Nothing>()
}