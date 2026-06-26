package com.example.ironasia.ui.module.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ironasia.R
import com.example.ironasia.ui.module.home.toInitial
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.DodgerBlue
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.LightPrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.Pink
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.White
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading3
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.heading5SemiBold
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph2

@Composable
fun UserCard(
    id: String,
    name: String,
    address: String,
    city: String,
    email: String,
    phoneNumber: String,
    gender: Int,
    onClick: (String) -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        onClick = {}
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Box(
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .background(color = LightPrimaryColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = name.toInitial(),
                    style = heading3,
                    color = PrimaryColor
                )
            }
            Spacer(modifier = Modifier.size(15.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = name,
                    style = heading5SemiBold
                )
                Spacer(modifier = Modifier.size(8.dp))
                UserData(
                    icon = R.drawable.ic_location_pin,
                    data = "$address, $city"
                )
                Spacer(modifier = Modifier.size(5.dp))
                UserData(
                    icon = R.drawable.ic_email,
                    data = email
                )
                Spacer(modifier = Modifier.size(5.dp))
                UserData(
                    icon = R.drawable.ic_phone,
                    data = phoneNumber
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .clip(CircleShape)
                        .background(
                            color =
                                if (gender == 1) Pink
                                else DodgerBlue
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(
                            id =
                                if (gender == 1) R.drawable.ic_female
                                else R.drawable.ic_male
                        ),
                        contentDescription = "Icon Gender",
                        tint = White
                    )
                }
                Spacer(modifier = Modifier.size(10.dp))
                IconButton(
                    modifier = Modifier.size(20.dp),
                    onClick = { onClick(id) }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_option),
                        contentDescription = "Icon Option"
                    )
                }
            }
        }
    }
}

@Composable
fun UserData(
    icon: Int,
    data: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(24.dp),
            painter = painterResource(id = icon),
            contentDescription = "Icon User Data"
        )
        Spacer(modifier = Modifier.size(5.dp))
        Text(
            text = data,
            style = paragraph2
        )
    }
}

@Preview
@Composable
fun UserCardPreview() {
    UserCard(
        id = "0",
        name = "Fajri Harlan",
        address = "Ciledug",
        city = "Tangerang",
        email = "fajri@gmail.com",
        phoneNumber = "08123456789",
        gender = 0,
        onClick = {}
    )
}