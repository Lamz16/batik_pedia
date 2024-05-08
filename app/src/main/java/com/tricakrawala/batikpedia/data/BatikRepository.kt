package com.tricakrawala.batikpedia.data

import com.tricakrawala.batikpedia.model.FakeSourceBatik
import com.tricakrawala.batikpedia.model.Nusantara
import com.tricakrawala.batikpedia.pref.UserModel
import com.tricakrawala.batikpedia.pref.UserPreference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BatikRepository(private val preference: UserPreference) {

    private val nusantaraList = mutableListOf<Nusantara>()

    init{
        if (nusantaraList.isEmpty()){
            FakeSourceBatik.listNusantara.forEach {
                nusantaraList.add(it)
            }
        }
    }

    suspend fun saveSession(user: UserModel) {
        preference.saveSession(user)
    }

    fun getSession(): Flow<UserModel> {
        return preference.getSession()
    }


    fun getAllNusantara(): Flow<List<Nusantara>> {
        return flowOf(nusantaraList)
    }

}