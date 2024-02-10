package com.example.accidetector.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.accidetector.R
import com.example.accidetector.viewmodel.LoginViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(viewModel: LoginViewModel,modifier: Modifier) {
    Column(
        modifier = modifier,
    ) {
        TextField(
            value = viewModel.emailField,
            onValueChange = { value ->
                viewModel.updateEmail(value)
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email"
                )
            },
            colors = TextFieldDefaults.textFieldColors(containerColor = Color.White),
            isError = !viewModel.isEmailValid( ),
            label = { Text(text = stringResource(id = R.string.enter_email)) },
            placeholder = { Text(text = stringResource(id = R.string.email)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        if (!viewModel.isEmailValid( )) {
            Text(text = "Email is not valid", color = Color.Red)
        }

    }
}
