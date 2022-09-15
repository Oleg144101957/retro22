package com.example.retro22.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retro22.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {

    val liveNumberDescription: MutableLiveData<String> = MutableLiveData()

    private val repo = Repository()

    fun getRandomNumberDescription(){
        viewModelScope.launch(Dispatchers.IO) {
            delay(3000)
            liveNumberDescription.postValue(repo.getRandomNumber())
        }
    }

    fun getNumberDescription(number: String){
        viewModelScope.launch(Dispatchers.IO) {
            liveNumberDescription.postValue(repo.getNumber(number))
        }
    }


}