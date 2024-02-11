package com.example.accidetector.presentation.login

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.accidetector.R
import com.example.accidetector.components.EmailTextField
import com.example.accidetector.viewmodel.LoginViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {

    Scaffold(topBar = {

        TopAppBar(

            title = {
                Box(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = UCharacter.toUpperCase(stringResource(id = R.string.app_title)),
                        fontSize = 30.sp,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            },

            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                colorResource(id = R.color.teal_700)
            )
        )

    }, containerColor = Color.White) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            EmailTextField(
                onChange = {value->  viewModel.updateEmail(value)},
                viewModel.emailField,
               modifier= Modifier
                    .padding(top = it.calculateTopPadding())
                    .padding(20.dp),
                isError = !viewModel.isEmailValid()
            )
            Box(modifier = Modifier.padding(bottom = 20.dp))
            Button(
                onClick = {
                    viewModel.handleLogin(navController)
                }, colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(
                        id = R.color.teal_700
                    )
                )
            ) {
                Text(text = stringResource(id = R.string.login))
            }
        }

    }
}