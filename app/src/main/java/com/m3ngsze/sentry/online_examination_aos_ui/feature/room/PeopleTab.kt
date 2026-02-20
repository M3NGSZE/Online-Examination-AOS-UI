package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.UserCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Profile
import java.util.UUID

@Composable
fun PeopleTab(

){
    Text(
        text = "Teachers",
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = Modifier
            .padding(vertical = 10.dp)
    )

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.LightGray
    )

    val profile = Profile(UUID.randomUUID(), "Chanelle", "Moon", null)
    UserCard(
        profile
    )

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    Text(
        text = "Classmates",
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(vertical = 10.dp)
    )

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.LightGray
    )

    UserCard(
        profile
    )
}