package com.m3ngsze.sentry.online_examination_aos_ui.core.constants

import com.google.gson.Gson
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.model.response.ApiErrorResponse
import retrofit2.HttpException

suspend fun <T> safeApiCall(apiCall: suspend () -> T): AppResult<T> {
    return try {
        AppResult.Success(apiCall())
    } catch (e: HttpException) {
        val errorJson = e.response()?.errorBody()?.string()
        val message = try {
            val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
            apiError.message
        } catch (_: Exception) {
            "Server error"
        }
        AppResult.Error(message)
    } catch (e: Exception) {
        AppResult.Error("Unexpected error: ${e.message}")
    }
}