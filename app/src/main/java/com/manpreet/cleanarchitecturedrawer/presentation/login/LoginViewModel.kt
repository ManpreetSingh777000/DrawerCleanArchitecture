package com.manpreet.cleanarchitecturedrawer.presentation.login

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.manpreet.cleanarchitecturedrawer.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.manpreet.cleanarchitecturedrawer.data.model.LoginResponse
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
):ViewModel() {
    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginState by mutableStateOf<LoginUiState>(LoginUiState.Idle)
        private set

    fun login(onSuccess: () -> Unit){
        viewModelScope.launch {
            loginState = LoginUiState.Loading
            try {
                val response=LoginResponse(email,password)
                loginState=LoginUiState.Success(response.username)
                onSuccess()
            }
            catch (e:Exception){
                loginState=LoginUiState.Error("Login Failed")
            }
        }
    }
}

