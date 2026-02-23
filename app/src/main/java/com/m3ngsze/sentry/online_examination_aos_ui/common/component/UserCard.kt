package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Profile

@Composable
fun UserCard(
    profile: Profile
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ){
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(Color.Gray, CircleShape)
            ) {
                AsyncImage(
                    model = profile.profileUrl
                        ?: R.drawable.profile,
                    contentDescription = "profile img",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Text(
                text = "${profile.lastName} ${profile.firstName}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 15.sp
            )
        }

        if (profile.status!=null){
            Text(
                text = profile.status,
                color = if (profile.status == "Assigned") Color.Gray else Color(0xFF1F7F15),
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}