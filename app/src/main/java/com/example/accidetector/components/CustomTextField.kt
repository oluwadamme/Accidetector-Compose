package com.example.accidetector.components

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.example.accidetector.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    onChange: (value: String) -> Any,
    fieldValue: String,
    isError: Boolean = false,
    label: String,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    errorText: String = stringResource(id = R.string.error_field),
    bgColor: Color = Color.White,
    leadingIcon: @Composable (() -> Unit)? = null
) {

    Column(

    ) {
        TextField(
            value = fieldValue,
            onValueChange = { it ->
                onChange(it)
            },
            modifier = Modifier.fillMaxWidth(),
            leadingIcon = leadingIcon,
            colors = TextFieldDefaults.textFieldColors(containerColor = bgColor),
            isError = isError,
            label = { Text(text = label) },
            placeholder = { Text(text = placeholder) },
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),

            )
        AnimatedVisibility(visible = isError) {
            Text(text = errorText, color = Color.Red)
        }

    }
}