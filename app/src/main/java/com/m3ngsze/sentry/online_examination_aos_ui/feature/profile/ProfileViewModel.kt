package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.m3ngsze.sentry.online_examination_aos_ui.core.constants.AppResult
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.User
import com.m3ngsze.sentry.online_examination_aos_ui.domain.usecase.UserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val userUseCase: UserUseCase
): ViewModel() {
    var userState by mutableStateOf<User?>(null)
        private set

    var errorState by mutableStateOf<String?>(null)
        private set

    fun getUserProfile(){
        viewModelScope.launch {
            errorState = null
            when (val result = userUseCase.getUserProfile()){
                is AppResult.Success -> {
                    userState = result.data
                    Log.d("ProfileViewModel", "userState after fetch = $userState")
                }
                is AppResult.Error -> {
                    errorState = result.message
                    Log.d("ProfileViewModel", "Error fetching user: $errorState")
                }
            }
        }
    }
}