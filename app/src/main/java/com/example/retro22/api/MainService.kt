package com.example.retro22.api

import retrofit2.http.GET
import retrofit2.http.Path

interface MainService {

    @GET("/random/math")
    suspend fun getNumberRandomDescription(): String

    @GET("/{number}")
    suspend fun getNumberDescription(@Path("number") number: String): String



}