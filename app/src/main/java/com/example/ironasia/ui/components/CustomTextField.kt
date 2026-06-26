package com.example.ironasia.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults.colors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ironasia.R
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.LightPrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph1

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    isSearch: Boolean = false,
    label: String = "",
    isEmail: Boolean = false,
    isPassword: Boolean = false
) {
    var passwordVisible by remember { mutableStateOf(false) }

    Column {
        if (!isSearch) {
            Text(
                text = label,
                style = paragraph1
            )
            Spacer(modifier =  Modifier.size(5.dp))
        }
        OutlinedTextField(
            placeholder = {
                if (isSearch) {
                    Text(text = "Search")
                }
            },
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            shape = RoundedCornerShape(5.dp),
            singleLine = true,
            textStyle = paragraph1,
            leadingIcon = if (isSearch) {
                {
                    Icon(
                        modifier = Modifier.size(28.dp),
                        painter = painterResource(id = R.drawable.ic_search),
                        contentDescription = "Icon Search"
                    )
                }
            } else null,
            colors = colors(
                focusedContainerColor = White,
                unfocusedContainerColor = White,

                // Border (Outline)
                focusedIndicatorColor = PrimaryColor,
                unfocusedIndicatorColor = LightPrimaryColor
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                    when {
                        isEmail -> KeyboardType.Email
                        isPassword -> KeyboardType.Password
                        else -> KeyboardType.Text
                    },
                capitalization = when {
                    isEmail || isPassword -> KeyboardCapitalization.None
                    else -> KeyboardCapitalization.Words
                },
                autoCorrectEnabled = !isPassword
            ),
            visualTransformation =
                if (isPassword && !passwordVisible) PasswordVisualTransformation()
                else VisualTransformation.None,
            trailingIcon =
                if (isPassword) {
                    {
                        IconButton(
                            modifier = Modifier.size(30.dp),
                            onClick = {
                                passwordVisible = !passwordVisible
                            }
                        ) {
                            Icon(
                                painter = painterResource(
                                    if (passwordVisible)
                                        R.drawable.ic_visibility
                                    else
                                        R.drawable.ic_visibility_off
                                ),
                                contentDescription = null
                            )
                        }
                    }
                } else null
        )
    }
}

@Preview
@Composable
fun CustomTextFieldPreview() {
    Surface(color = White) {
        CustomTextField(
            value = "",
            onValueChange = {},
            isSearch = false,
            label = "Nama Lengkap"
        )
    }
}