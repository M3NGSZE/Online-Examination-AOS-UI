package com.m3ngsze.sentry.online_examination_aos_ui.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject

val Context.dataStore by preferencesDataStore(name = "auth_prefs")

class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
)  {

    companion object {
        val KEY_AUTH_TOKEN = stringPreferencesKey("auth_token")
    }

    suspend fun saveAuthToken(token: String) {
        context.dataStore.edit { prefs ->
            prefs[KEY_AUTH_TOKEN] = token
        }
    }

    suspend fun getAuthToken(): String? {
        val prefs = context.dataStore.data.first()
        return prefs[KEY_AUTH_TOKEN]
    }

    suspend fun clearSession() {
        context.dataStore.edit { it.clear() }
    }
}
