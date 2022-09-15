package com.example.retro22.ViewModel

import android.app.Application
import androidx.lifecycle.*
import com.example.retro22.db.HistoryDatabase
import com.example.retro22.model.Numb
import com.example.retro22.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BaseViewModel(application: Application) : AndroidViewModel(application) {

    val liveNumberDescription: MutableLiveData<String> = MutableLiveData()
    val liveHistoryList: LiveData<List<Numb>>
    private val repo: Repository

    init {
        val historyDao = HistoryDatabase.getHistoryDatabase(application.applicationContext).historyDao()
        repo = Repository(historyDao)
        liveHistoryList = repo.getAllHistoryFromDatabase()
    }

    fun getRandomNumberDescription(){
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            liveNumberDescription.postValue(repo.getRandomNumber())
        }
    }

    fun getNumberDescription(number: String){
        viewModelScope.launch(Dispatchers.IO) {
            delay(2000)
            liveNumberDescription.postValue(repo.getNumber(number))
        }
    }

    fun addNumberToHistory(numb: Numb){
        viewModelScope.launch (Dispatchers.IO){
            repo.addNumberToDatabase(numb)
        }
    }
}