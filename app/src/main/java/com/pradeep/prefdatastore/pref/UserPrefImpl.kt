package com.pradeep.prefdatastore.pref

import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class UserPrefImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
):UserPref {
    override fun getName(): Flow<String> {
        return dataStore.data.catch {
            emit(emptyPreferences())
        }.map {
            it[USER_KEY]?:"NaN"
        }
    }

    override suspend fun saveUser(name: String) {
        dataStore.edit {
            it[USER_KEY]=name
        }
    }
}