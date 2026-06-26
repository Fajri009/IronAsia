package com.example.ironasia.ui.module.contact.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
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
import com.example.ironasia.ui.module.home.toInitial
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.LightPrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading2
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading4SemiBold
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading5SemiBold
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph1
import com.example.ironasia.viewmodel.contact.detail.DetailContactViewModelType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@Composable
fun DetailContactScreen(
    viewModel: DetailContactViewModelType,
    userId: String,
    navigateBack: () -> Unit
) {
    val userData by viewModel.userData.collectAsStateWithLifecycle()

    val name = userData?.name ?: ""

    LaunchedEffect(userId) {
        viewModel.getUserById(userId)
    }

    Scaffold(containerColor = White) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp)
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
                Spacer(modifier = Modifier.size(20.dp))
                Text(
                    text = name,
                    style = heading4SemiBold
                )
            }
            Spacer(modifier = Modifier.size(30.dp))
            UserInfo(
                icon = R.drawable.ic_location_pin,
                data = "${userData?.address}, ${userData?.city}"
            )
            Spacer(modifier = Modifier.size(15.dp))
            UserInfo(
                icon = R.drawable.ic_email,
                data = userData?.email ?: ""
            )
            Spacer(modifier = Modifier.size(15.dp))
            UserInfo(
                icon = R.drawable.ic_phone,
                data = userData?.phoneNumber ?: ""
            )
            Spacer(modifier = Modifier.size(30.dp))
            Row {
                CustomButton(
                    modifier = Modifier.weight(1f),
                    text = "Edit",
                    onClick = {}
                )
                Spacer(modifier = Modifier.size(10.dp))
                CustomButton(
                    modifier = Modifier.weight(1f),
                    text = "Delete",
                    isError = true,
                    onClick = {
                        viewModel.deleteUser(userId)
                        navigateBack()
                    }
                )
            }
        }
    }
}

@Composable
fun UserInfo(
    icon: Int,
    data: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(28.dp),
            painter = painterResource(id = icon),
            contentDescription = "Icon User Data"
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(
            text = data,
            style = paragraph1
        )
    }
}

@Preview
@Composable
private fun DetailContactScreenPreview() {
    val viewModel = object : DetailContactViewModelType {
        override val userData: StateFlow<UserItem?> = MutableStateFlow(null)

        override fun getUserById(id: String) { }
        override fun deleteUser(id: String) { }

    }

    DetailContactScreen(
        viewModel = viewModel,
        userId = "0",
        navigateBack = {}
    )
}