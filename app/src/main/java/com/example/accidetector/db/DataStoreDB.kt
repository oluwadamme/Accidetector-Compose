package com.example.accidetector.db

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreDB(private val context: Context) {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_info")
    fun readStringDataFromDB(key: String): Flow<String> {
        val keyValue = stringPreferencesKey(key)
        val value: Flow<String> = context.dataStore.data.map { preferences ->
            preferences[keyValue] ?: ""
        }

        return value
    }

    suspend fun writeStringDataFromDB(key: String, value: String) {
        val keyValue = stringPreferencesKey(key)
        context.dataStore.edit { settings ->
            settings[keyValue] = value
        }
    }

}