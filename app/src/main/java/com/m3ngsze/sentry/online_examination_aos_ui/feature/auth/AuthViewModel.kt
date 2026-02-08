package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.response.ApiErrorResponse
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase
) : ViewModel() {

    var authState by mutableStateOf<Auth?>(null)
        private set

    var userState by mutableStateOf<User?>(null)
        private set

    var errorState by mutableStateOf<String?>(null)
        private set

    fun login(email: String, password: String){
        viewModelScope.launch {
            errorState = null // Clear previous errors
            try {
                authState = authUseCase.login(email, password)
            }catch (e: HttpException) {

                val errorJson = e.response()?.errorBody()?.string()

                val message = try {
                    val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                    apiError.message
                } catch (_: Exception) {
                    "Server error"
                }
                errorState = message
            }

        }
    }

    fun register(request: RegisterRequest){
        viewModelScope.launch {
            errorState = null // Clear previous errors
            try {
                userState = authUseCase.register(request)
            }catch (e: HttpException) {

                val errorJson = e.response()?.errorBody()?.string()

                val message = try {
                    val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                    apiError.message
                } catch (_: Exception) {
                    "Server error"
                }
                errorState = message
            }

        }
    }

    fun verifyOtp(email: String, otp: String){
        viewModelScope.launch {
            errorState = null // Clear previous errors
            try {
                authUseCase.verifyOtp(email, otp)
            }catch (e: HttpException) {

                val errorJson = e.response()?.errorBody()?.string()

                val message = try {
                    val apiError = Gson().fromJson(errorJson, ApiErrorResponse::class.java)
                    apiError.message
                } catch (_: Exception) {
                    "Server error"
                }
                errorState = message
            }

        }
    }
}