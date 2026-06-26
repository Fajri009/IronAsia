package com.example.ironasia.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        private val Context.dataStore by preferencesDataStore("session")

        private val IS_LOGIN =
            booleanPreferencesKey("is_login")
    }

    val isLogin =
        context.dataStore.data.map {
            it[IS_LOGIN] ?: false
        }

    suspend fun saveLogin() {
        context.dataStore.edit {
            it[IS_LOGIN] = true
        }
    }

    suspend fun logout() {
        context.dataStore.edit {
            it[IS_LOGIN] = false
        }
    }
}