package com.example.ironasia.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading6Bold

@Composable
fun CustomButton(
    enabled: Boolean = true,
    text: String,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(13.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = PrimaryColor
        ),
        onClick = onClick,
        enabled = enabled
    ) {
        Text(
            modifier = Modifier.padding(vertical = 10.dp),
            text = text,
            style = heading6Bold
        )
    }
}