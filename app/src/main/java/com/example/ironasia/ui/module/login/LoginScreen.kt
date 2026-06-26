package com.example.ironasia.ui.module.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ironasia.R
import com.example.ironasia.ui.components.CustomButton
import com.example.ironasia.ui.components.CustomDialog
import com.example.ironasia.ui.components.CustomTextField
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.Gray
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading5SemiBold
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph1
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph2

@Composable
fun LoginScreen(
    navigateHome: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.size(30.dp))
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(R.drawable.logo_apk),
                contentDescription = "Logo Apk"
            )
            Spacer(modifier = Modifier.size(20.dp))
            Text(
                text = "Welcome Back",
                style = heading5SemiBold
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(
                text = "Please login to continue",
                style = paragraph2,
                color = Gray
            )
            Spacer(modifier = Modifier.size(40.dp))
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email",
                isEmail = true
            )
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                value = password,
                onValueChange = { password = it },
                label = "Password",
                isPassword = true
            )
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Forgot Password?",
                style = paragraph1,
                color = PrimaryColor,
                textAlign = TextAlign.End
            )
            Spacer(modifier = Modifier.size(25.dp))
            CustomButton(
                text = "Login",
                enabled = !(email.isEmpty() || password.isEmpty()),
                onClick = {
                    if (email != "admin@gmail.com" && password != "admin123") {
                        showDialog = true
                    } else {
                        navigateHome()
                    }
                }
            )
            Spacer(modifier = Modifier.size(25.dp))
            Row {
                Text(
                    text = "Don't have an account?",
                    style = paragraph1
                )
                Spacer(modifier = Modifier.size(5.dp))
                Text(
                    text = "Sign Up",
                    style = paragraph1,
                    color = PrimaryColor
                )
            }
        }

        if (showDialog) {
            CustomDialog(
                title = "Login",
                message = "Email atau password tidak sesuai",
                confirm = { showDialog = false }
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen({})
}