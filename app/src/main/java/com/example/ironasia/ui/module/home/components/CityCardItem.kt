package com.example.ironasia.ui.module.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ironasia.R
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.LightPrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Color.Companion.PrimaryColor
import com.example.ironasia.ui.theme.IronAsiaAppTheme.Text.Companion.paragraph1

@Composable
fun CityCardItem(
    city: String,
    selected: Boolean,
    onSelect: (String) -> Unit
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = LightPrimaryColor),
        border =
            if (selected) null
            else {
                BorderStroke(
                    width = 1.dp,
                    color = PrimaryColor
                )
            },
        onClick = { onSelect(city) }
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (selected) {
                Icon(
                    modifier = Modifier.size(17.dp),
                    painter = painterResource(id = R.drawable.ic_check),
                    contentDescription = "Icon Checklist",
                    tint = PrimaryColor
                )
                Spacer(modifier = Modifier.size(3.dp))
            }
            Text(
                text = city,
                style = paragraph1,
                color = PrimaryColor
            )
        }
    }
}

@Preview
@Composable
private fun CityCardItemPreview() {
    CityCardItem(
        city = "Tangerang",
        selected = true,
        onSelect = {}
    )
}