package com.example.ironasia.ui.module.contact.edit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ironasia.R
import com.example.ironasia.data.repository.model.userResponse.UserItem
import com.example.ironasia.ui.components.CustomButton
import com.example.ironasia.ui.components.CustomTextField
import com.example.ironasia.ui.module.home.toInitial
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.LightPrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading2
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading5SemiBold
import com.example.ironasia.viewmodel.contact.Edit.EditContactViewModelType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun EditContactScreen(
    viewModel: EditContactViewModelType,
    userId: String,
    navigateBack: () -> Unit
) {
    val userData by viewModel.userData.collectAsStateWithLifecycle()

    var name by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var phoneNumber by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(userId) {
        viewModel.getUserById(userId)
    }

    LaunchedEffect(userData) {
        userData?.let {
            name = it.name
            email = it.email
            phoneNumber = it.phoneNumber
            address = it.address
        }
    }

    Scaffold(containerColor = White) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.size(20.dp))
            Row {
                IconButton(
                    modifier = Modifier.size(30.dp),
                    onClick = navigateBack
                ) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.ic_back_page),
                        contentDescription = "Icon Back Page"
                    )
                }
                Spacer(modifier = Modifier.size(15.dp))
                Text(
                    text = "Account Detail",
                    style = heading5SemiBold
                )
            }
            Spacer(modifier = Modifier.size(20.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(color = LightPrimaryColor),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = name.toInitial(),
                        style = heading2,
                        color = PrimaryColor
                    )
                }
            }
            Spacer(modifier = Modifier.size(30.dp))
            CustomTextField(
                value = name,
                onValueChange = { name = it },
                label = "Full Name"
            )
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                value = email,
                onValueChange = { email = it },
                label = "Email"
            )
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = "Phone Number"
            )
            Spacer(modifier = Modifier.size(20.dp))
            CustomTextField(
                value = address,
                onValueChange = { address = it },
                label = "Address"
            )
            Spacer(modifier = Modifier.size(30.dp))
            CustomButton(
                text = "Save",
                enabled = !(name.isEmpty() || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()),
                onClick = {
                    userData?.let {
                        viewModel.updateUser(
                            it.copy(
                                name = name,
                                email = email,
                                phoneNumber = phoneNumber,
                                address = address
                            )
                        )

                        navigateBack()
                    }
                }
            )
        }
    }
}

@Preview
@Composable
private fun EditContactScreenPreview() {
    val viewModel = object : EditContactViewModelType {
        override val userData: StateFlow<UserItem?> = MutableStateFlow(null)

        override fun getUserById(id: String) { }
        override fun updateUser(user: UserItem) { }
    }

    EditContactScreen(
        viewModel = viewModel,
        userId = "0",
        navigateBack = {}
    )
}