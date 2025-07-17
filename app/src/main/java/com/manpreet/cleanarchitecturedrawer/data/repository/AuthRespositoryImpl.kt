package com.manpreet.cleanarchitecturedrawer.data.repository

import com.manpreet.cleanarchitecturedrawer.data.model.LoginRequest
import com.manpreet.cleanarchitecturedrawer.data.model.LoginResponse
import com.manpreet.cleanarchitecturedrawer.data.network.AuthApi
import com.manpreet.cleanarchitecturedrawer.domain.repository.AuthRepository

class AuthRespositoryImpl(private val api: AuthApi):AuthRepository {
    override suspend fun login(request: LoginRequest): LoginResponse {
        return LoginResponse("Token a134565","Manpreet")
    }
}