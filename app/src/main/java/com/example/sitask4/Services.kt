package com.example.sitask4

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface Services {
    @GET("{username}")
    suspend fun getUserData(@Path ("username") username: String): UserData
}