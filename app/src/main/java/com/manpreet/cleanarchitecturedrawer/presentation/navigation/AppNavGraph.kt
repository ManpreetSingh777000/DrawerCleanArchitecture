package com.manpreet.cleanarchitecturedrawer.presentation.navigation



import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.manpreet.cleanarchitecturedrawer.presentation.home.DrawerScreen
import com.manpreet.cleanarchitecturedrawer.presentation.login.LoginScreen
import com.manpreet.cleanarchitecturedrawer.presentation.splash.SplashScreen


@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("login") { LoginScreen(navController) }
        composable("home") { DrawerScreen() }
        composable("drawer") { DrawerScreen() }
    }
}


