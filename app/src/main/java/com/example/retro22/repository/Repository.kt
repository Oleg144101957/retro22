package com.example.retro22.repository

import com.example.retro22.api.RetrofitInstance

class Repository {

    suspend fun getRandomNumber(): String{
        return RetrofitInstance.api.getNumberRandomDescription()
    }

    suspend fun getNumber(number: String): String{
        return RetrofitInstance.api.getNumberDescription(number)
    }

}