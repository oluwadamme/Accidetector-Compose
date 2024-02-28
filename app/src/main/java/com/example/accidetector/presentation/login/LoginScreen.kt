package com.example.accidetector.presentation.login

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.accidetector.R
import com.example.accidetector.components.CustomButton
import com.example.accidetector.components.CustomScaffold
import com.example.accidetector.components.EmailTextField
import com.example.accidetector.utils.route.Routes
import com.example.accidetector.viewmodel.LoginViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun LoginScreen(viewModel: LoginViewModel, navController: NavController) {
    viewModel.emailField=viewModel.getEmail().collectAsState(initial = "").value
    CustomScaffold(appBarTitle = stringResource(id = R.string.app_title)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            EmailTextField(
                onChange = { value -> viewModel.updateEmail(value) },
                viewModel.emailField,
                modifier = Modifier
                    .padding(top = it.calculateTopPadding())
                    .padding(20.dp),
                isError = !viewModel.isEmailValid()
            )
            Box(modifier = Modifier.padding(bottom = 20.dp))
            CustomButton(
                text = stringResource(id = R.string.login),
                onClick = {
                    viewModel.handleLogin(navController)
                },
            )
            Box(modifier = Modifier.padding(bottom = 100.dp))
            ClickableText(text = buildAnnotatedString {
                append("Don't have an account ")
                withStyle(
                    style = SpanStyle(
                        Color.Green, textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("Create one")
                }
            }, onClick = {
                navController.navigate(Routes.SignUpScreen.name)
            })
        }
    }
}


