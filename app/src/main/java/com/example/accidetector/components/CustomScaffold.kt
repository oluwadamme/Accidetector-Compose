package com.example.accidetector.components

import android.annotation.SuppressLint
import android.icu.lang.UCharacter
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.unit.sp
import com.example.accidetector.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold(appBarTitle: String, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = {

            TopAppBar(

                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = UCharacter.toUpperCase(appBarTitle),
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

        },
        containerColor = Color.White,
        content = content
    )
}