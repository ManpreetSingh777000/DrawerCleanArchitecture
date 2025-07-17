package com.manpreet.cleanarchitecturedrawer.data.network

import com.manpreet.cleanarchitecturedrawer.data.model.LoginRequest
import com.manpreet.cleanarchitecturedrawer.data.model.LoginResponse
import com.manpreet.cleanarchitecturedrawer.data.model.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApi {
    @POST("Login")
    suspend fun login(@Body request: LoginRequest): LoginResponse

    @GET("user")
    suspend fun getUser(): User

}