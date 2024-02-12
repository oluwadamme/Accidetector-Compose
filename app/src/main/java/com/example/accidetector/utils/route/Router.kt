package com.example.accidetector.utils.route

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.accidetector.presentation.login.LoginScreen
import com.example.accidetector.presentation.signup.SignUpScreen
import com.example.accidetector.viewmodel.LoginViewModel

@Composable
fun Router(hostController: NavHostController) {
    val loginViewModel: LoginViewModel = hiltViewModel()

    NavHost(navController = hostController, startDestination = Routes.LoginScreen.name) {
        composable(Routes.LoginScreen.name) {
            LoginScreen(loginViewModel, hostController)
        }
        composable(Routes.SignUpScreen.name) {
            SignUpScreen()
        }
    }
}

val NavHostController.parentRoute: Routes
    get() = this.currentBackStackEntry.let {
        val route = it?.destination?.route?.split("/")?.first() ?: Routes.LoginScreen.name

        val parentRoute = when (Routes.valueOf(route)) {
            Routes.LoginScreen -> Routes.LoginScreen
            Routes.HomeScreen -> Routes.HomeScreen
            Routes.SensorScreen -> Routes.SensorScreen
            Routes.SignUpScreen -> Routes.SignUpScreen
            Routes.UserInfoScreen -> Routes.UserInfoScreen
        }
        return parentRoute
    }