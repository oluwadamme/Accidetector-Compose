package com.example.accidetector.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.accidetector.service.DataStoreService
import com.example.accidetector.utils.route.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel  @Inject constructor(private val service: DataStoreService) : ViewModel() {
    var emailField by mutableStateOf("")
    fun updateEmail(value: String) {
        emailField = value.trim()
    }

    fun isEmailValid(): Boolean {
        if (emailField.isEmpty()) {
            return true
        }
        // Add your custom validation rules here
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return emailField.matches(emailRegex)
    }

    fun handleLogin(navController: NavController) {
        if (isEmailValid()) {
          val state=  viewModelScope.launch {
                service.writeStringDataFromDB("email", emailField)
            }
            if (state.isCompleted){
                navController.navigate(Routes.HomeScreen.name)
            }

        }
    }

}