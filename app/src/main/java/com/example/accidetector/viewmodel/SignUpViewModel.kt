package com.example.accidetector.viewmodel

import android.widget.Toast
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
class SignUpViewModel @Inject constructor(private val service: DataStoreService) : ViewModel() {


    var nameField by mutableStateOf("")
    var emailField by mutableStateOf("")
    var phoneField by mutableStateOf("")
    var kinNameField by mutableStateOf("")
    var kinEmailField by mutableStateOf("")
    var kinPhoneField by mutableStateOf("")

    fun updateEmail(value: String) {
        emailField = value.trim()
    }

    fun updateName(value: String) {
        nameField = value.trim()
    }

    fun updatePhone(value: String) {
        phoneField = value.trim()
    }

    fun updateKinEmail(value: String) {
        kinEmailField = value.trim()
    }

    fun updateKinName(value: String) {
        kinNameField = value.trim()
    }

    fun updateKinPhone(value: String) {
        kinPhoneField = value.trim()
    }

    fun isEmailValid(): Boolean {
        if (emailField.isEmpty()) {
            return false
        }
        // Add your custom validation rules here
        val emailRegex = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+".toRegex()
        return emailField.matches(emailRegex)
    }

    fun handleSignup(navController: NavController) {
        if (validateField()) {
            val state = viewModelScope.launch {
                service.writeStringDataFromDB("email", emailField)
                service.writeStringDataFromDB("name", nameField)
                service.writeStringDataFromDB("phone", phoneField)
                service.writeStringDataFromDB("kinEmail", kinEmailField)
                service.writeStringDataFromDB("kinName", kinNameField)
                service.writeStringDataFromDB("kinPhone", kinPhoneField)
            }
            state.invokeOnCompletion(
                handler = {
                    navController.navigate(Routes.DashboardScreen.name)
                },
            )

        } else {
            Toast.makeText(navController.context, "Fill all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun validateField(): Boolean {

        return nameField.isNotEmpty() && isEmailValid() && phoneField.isNotEmpty() && kinNameField.isNotEmpty() && kinEmailField.isNotEmpty() && kinPhoneField.isNotEmpty()
    }
}