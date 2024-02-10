package com.example.accidetector

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpace
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.accidetector.components.EmailTextField
import com.example.accidetector.ui.theme.AccidetectorTheme
import com.example.accidetector.viewmodel.LoginViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AccidetectorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = LoginViewModel()
                    LoginScreen(viewModel)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel) {

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
                viewModel, Modifier
                    .padding(top = it.calculateTopPadding())
                    .padding(20.dp)
            )
            Box(modifier = Modifier.padding(bottom = 20.dp))
            Button(
                onClick = {
                          viewModel.handleLogin()
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