package com.example.accidetector.presentation.signup

import android.widget.ScrollView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.accidetector.R
import com.example.accidetector.components.CustomButton
import com.example.accidetector.components.CustomScaffold
import com.example.accidetector.components.CustomTextField
import com.example.accidetector.components.EmailTextField
import com.example.accidetector.utils.route.Routes
import com.example.accidetector.viewmodel.SignUpViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(viewModel: SignUpViewModel, navController: NavController) {
    CustomScaffold(appBarTitle = stringResource(id = R.string.app_title), navigationIcon = {
        IconButton(onClick = { navController.popBackStack() }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Button")
        }
    }) { pad ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(top = pad.calculateTopPadding())
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {

            CustomTextField(
                onChange = {
                    viewModel.updateName(it)
                },
                fieldValue = viewModel.nameField,
                label = stringResource(id = R.string.name),
                placeholder = stringResource(id = R.string.name),
            )

            CustomTextField(
                onChange = {
                    viewModel.updateEmail(it)
                },
                fieldValue = viewModel.emailField,
                label = stringResource(id = R.string.email),
                placeholder = stringResource(id = R.string.email),
                keyboardType = KeyboardType.Email
            )

            CustomTextField(
                onChange = {
                    viewModel.updatePhone(it)
                },
                fieldValue = viewModel.phoneField,
                label = stringResource(id = R.string.phone),
                placeholder = stringResource(id = R.string.phone),
                keyboardType = KeyboardType.Phone
            )

            CustomTextField(
                onChange = {
                    viewModel.updateKinName(it)
                },
                fieldValue = viewModel.kinNameField,
                label = stringResource(id = R.string.kinName),
                placeholder = stringResource(id = R.string.kinName)
            )

            CustomTextField(
                onChange = {
                    viewModel.updateKinEmail(it)
                },
                fieldValue = viewModel.kinEmailField,
                label = stringResource(id = R.string.kinEmail),
                placeholder = stringResource(id = R.string.kinEmail),
                keyboardType = KeyboardType.Email
            )

            CustomTextField(
                onChange = {
                    viewModel.updateKinPhone(it)
                },
                fieldValue = viewModel.kinPhoneField,
                label = stringResource(id = R.string.kinPhone),
                placeholder = stringResource(id = R.string.kinPhone),
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done,
            )

            CustomButton(
                text = stringResource(id = R.string.submit),
                onClick = {
                    viewModel.handleSignup(navController)
                },
            )

            ClickableText(
                text = buildAnnotatedString {
                    append("Already have an account ")
                    withStyle(
                        style = SpanStyle(
                            Color.Green, textDecoration = TextDecoration.Underline
                        )
                    ) {
                        append("login")
                    }
                },
                onClick = {
                    navController.navigate(Routes.LoginScreen.name)
                },
            )
        }

    }
}