package com.example.ironasia.ui.module.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White

@Composable
fun LoginScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = White
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Text("Halo Admin!")
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen()
}