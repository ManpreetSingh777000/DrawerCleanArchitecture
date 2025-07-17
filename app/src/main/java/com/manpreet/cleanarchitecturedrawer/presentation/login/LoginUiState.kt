package com.manpreet.cleanarchitecturedrawer.presentation.login

sealed class LoginUiState {
    object Idle:LoginUiState()
    object Loading:LoginUiState()
    data class Success(val useerName:String):LoginUiState()
    data class Error(val message:String):LoginUiState()

}
