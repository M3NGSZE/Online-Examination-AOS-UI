package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AlternateEmail
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InfoTab(){
    InfoCard(
        label = "Email",
        icon = Icons.Default.AlternateEmail,
        value = "exam@gmail.com"
    )

    InfoCard(
        label = "Location",
        icon = Icons.Default.PhoneAndroid,
        value = "0987654321"
    )

    InfoCard(
        label = "Location",
        icon = Icons.Default.LocationOn,
        value = "Phnom Penh"
    )
}

@Composable
fun InfoCard(
    label: String,
    icon: ImageVector,
    value: String
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Icon(
                imageVector = icon,
                contentDescription = "Assignment",
                tint = Color.Gray
            )

            Spacer(
                modifier = Modifier
                    .width(15.dp),
            )

            Column {
                Text(
                    text = label,
                    color = Color.Gray,
                    fontSize = 16.sp
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = value,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    minLines = 1
                )
            }

        }

    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.LightGray
    )

    Spacer(
        modifier = Modifier
            .height(25.dp)
    )

}