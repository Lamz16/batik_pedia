package com.tricakrawala.batikpedia.data

import com.tricakrawala.batikpedia.pref.UserModel
import com.tricakrawala.batikpedia.pref.UserPreference
import kotlinx.coroutines.flow.Flow

class BatikRepository(private val preference: UserPreference) {

    suspend fun saveSession(user: UserModel) {
        preference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return preference.getSession()
    }

}