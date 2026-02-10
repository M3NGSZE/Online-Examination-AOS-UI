package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import com.m3ngsze.sentry.online_examination_aos_ui.data.remote.request.RegisterRequest
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Auth
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val sessionManager: SessionManager
) : ViewModel() {

    var authState by mutableStateOf<Auth?>(null)
        private set

    var userState by mutableStateOf<User?>(null)
        private set

    var verifyState by mutableStateOf<Boolean?>(null)
        private set


    var errorState by mutableStateOf<String?>(null)
        private set

    fun login(email: String, password: String){
        viewModelScope.launch {
            errorState = null
            when (val result = authUseCase.login(email, password)) {
                is AppResult.Success -> authState = result.data
                is AppResult.Error -> errorState = result.message
            }
        }
    }

    fun register(request: RegisterRequest){
        viewModelScope.launch {
            errorState = null
            when (val result = authUseCase.register(request)) {
                is AppResult.Success -> userState = result.data
                is AppResult.Error -> errorState = result.message
            }
        }
    }

    fun verifyOtp(email: String?, otp: String){
        viewModelScope.launch {
            errorState = null
            when (val result = authUseCase.verifyOtp(email, otp)) {
                is AppResult.Success -> verifyState = result.data
                is AppResult.Error -> errorState = result.message
            }
        }
    }

    fun sendOtp(email: String?){
        viewModelScope.launch {
            errorState = null
            when (val result = authUseCase.sendOtp(email)) {
                is AppResult.Success -> verifyState = result.data
                is AppResult.Error -> errorState = result.message
            }
        }
    }

}