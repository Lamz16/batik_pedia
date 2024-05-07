package com.tricakrawala.batikpedia

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.tricakrawala.batikpedia.data.BatikRepository
import com.tricakrawala.batikpedia.pref.UserModel

class MainViewModel(private  val repository: BatikRepository): ViewModel(){

    fun getSession(): LiveData<UserModel> {
        return repository.getSession().asLiveData()
    }

}