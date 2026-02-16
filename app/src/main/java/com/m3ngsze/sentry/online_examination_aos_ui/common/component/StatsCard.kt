package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatCardSmall(
    number: String,
    label: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(
                color = Color(0xFFE4E5E9),
                shape = RoundedCornerShape(20)
            )
            .padding(vertical = 20.dp, horizontal = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = number,
            fontWeight = FontWeight.SemiBold,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF757575)
        )
    }
}

@Composable
fun StatCardLarge(
    number: String,
    label: String,
    modifier: Modifier = Modifier,
    fontSize: TextUnit,
    textSize : TextUnit
) {
    Card(
        modifier = modifier.height(100.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

            ) {
            Text(
                text = number,
                fontWeight = FontWeight.SemiBold,
                fontSize = fontSize
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = label,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF757575),
                fontSize = textSize
            )
        }
    }
}

@Composable
fun StatItem(
    number: String,
    label: String
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = number,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            color = Color(0xFF757575)
        )
    }
}

@Composable
fun ProfileCardInfo(
    value: String,
    label: String
){
    Column {
        Text(
            text = value,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp
        )

        Spacer(
            modifier = Modifier
                .height(5.dp)
        )

        Text(
            text = label,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            color = Color(0xFF959595)
        )
    }
}