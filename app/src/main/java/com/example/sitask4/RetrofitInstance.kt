package com.example.sitask4

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Utility.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: Services by lazy {
        retrofit.create(Services::class.java)
    }
}