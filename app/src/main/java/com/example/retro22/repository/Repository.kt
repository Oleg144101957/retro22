package com.example.retro22.repository

import androidx.lifecycle.LiveData
import com.example.retro22.api.RetrofitInstance
import com.example.retro22.db.HistoryDao
import com.example.retro22.model.Numb

class Repository(private val historyDao: HistoryDao) {


    suspend fun getRandomNumber(): String{
        return RetrofitInstance.api.getNumberRandomDescription()
    }

    suspend fun getNumber(number: String): String{
        return RetrofitInstance.api.getNumberDescription(number)
    }

    suspend fun addNumberToDatabase(numb: Numb){
        historyDao.addNumber(numb)
    }

    fun getAllHistoryFromDatabase() : LiveData<List<Numb>>{
        return historyDao.readAllHistory()
    }

}