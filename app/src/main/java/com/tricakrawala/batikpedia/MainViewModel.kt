package com.tricakrawala.batikpedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.pref.UserModel
import kotlinx.coroutines.launch

class MainViewModel(private  val repository: BatikRepository): ViewModel(){

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

    fun saveSession(user: UserModel) {
        viewModelScope.launch {
            repository.saveSession(user)
        }
    }

}