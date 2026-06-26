package com.example.ironasia.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor

@Composable
fun CustomDialog(
    modifier: Modifier = Modifier,
    title: String,
    message: String,
    dismiss: (() -> Unit)? = null,
    confirm: () -> Unit
) {
    AlertDialog(
        modifier = modifier,
        onDismissRequest = dismiss ?: confirm,
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            Button(
                onClick = confirm,
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
            ) {
                Text("OK")
            }
        },
    )
}