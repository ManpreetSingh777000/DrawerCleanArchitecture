package com.manpreet.cleanarchitecturedrawer.domain.repository

import com.manpreet.cleanarchitecturedrawer.data.model.LoginRequest
import com.manpreet.cleanarchitecturedrawer.data.model.LoginResponse

interface AuthRepository {
    suspend fun login(request: LoginRequest):LoginResponse
}