package com.example.accidetector.components

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.accidetector.R

@Composable
fun CustomButton(
    text: String, onClick: () -> Unit
) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(
                id = R.color.teal_700
            )
        ), elevation = ButtonDefaults.elevatedButtonElevation(10.dp)
    ) {
        Text(text = text)
    }
}
