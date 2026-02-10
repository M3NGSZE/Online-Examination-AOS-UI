package com.m3ngsze.sentry.online_examination_aos_ui.feature.splash

import androidx.lifecycle.ViewModel
import com.m3ngsze.sentry.online_examination_aos_ui.data.local.SessionManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel  @Inject constructor(
    private val sessionManager: SessionManager
) : ViewModel(){

    suspend fun isLoggedIn(): Boolean {
        val token = sessionManager.getAccessToken()
        return !token.isNullOrEmpty()
    }

}