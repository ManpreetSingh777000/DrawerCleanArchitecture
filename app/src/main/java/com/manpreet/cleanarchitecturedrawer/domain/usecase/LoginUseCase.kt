package com.manpreet.cleanarchitecturedrawer.domain.usecase

import com.manpreet.cleanarchitecturedrawer.data.model.LoginRequest
import com.manpreet.cleanarchitecturedrawer.data.model.LoginResponse
import com.manpreet.cleanarchitecturedrawer.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {
    suspend operator fun invoke(email:String, password:String):LoginResponse{
        return  repository.login(LoginRequest(email,password))
    }
}