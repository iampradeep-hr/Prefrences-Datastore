package com.pradeep.prefdatastore.pref

import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

val USER_KEY= stringPreferencesKey("user_name")
interface UserPref {

    fun getName():Flow<String>

    suspend fun saveUser(name:String)
}