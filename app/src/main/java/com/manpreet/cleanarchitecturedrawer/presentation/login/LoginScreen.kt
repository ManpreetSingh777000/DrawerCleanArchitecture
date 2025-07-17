package com.manpreet.cleanarchitecturedrawer.presentation.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun LoginScreen(navController: NavController,viewModel: LoginViewModel=hiltViewModel()){
    val loginSate= viewModel.loginState

    Column (
        Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    )
    {
        TextField(
            value = viewModel.email,
            onValueChange = {viewModel.email=it},
            label = { Text("Email") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = viewModel.password,
            onValueChange = {viewModel.password=it},
            label = { Text("password")}
            )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.login { navController.navigate("home") } },
            enabled = loginSate !is LoginUiState.Loading
        ) {
            Text(if( loginSate is LoginUiState.Loading) "Logging in.." else "Login")
        }

        when(loginSate){

            is LoginUiState.Error->{
                Spacer(modifier = Modifier.height(8.dp))
                Text((loginSate as LoginUiState.Error).message, color = Color.Red)

            }


            is LoginUiState.Success->{
                Spacer(modifier = Modifier.height(8.dp))
                Text("Welcome ", color = Color.Green)

            }


            else -> {

            }
        }


    }

}