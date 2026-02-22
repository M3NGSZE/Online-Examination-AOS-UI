package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.HeaderRoomInfo
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun RoomInfoScreen(
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {
        HeaderRoomInfo (
            title = "About"
        ){
            navController.navigate(Screen.RoomDetail.route)
        }

        InfoContent()
    }
}

@Composable
fun InfoContent(

){
    ContentItem(
        head = "Class name",
        tail = "PVH Class"
    )

    ContentItem(
        head = "Section",
        tail = "Full Shift"
    )

    ContentItem(
        head = "Subject",
        tail = "N/A"
    )
}

@Composable
fun ContentItem(
    head: String,
    tail: String
){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ){
        Text(
            text = head,
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        Text(
            text = tail,
            fontSize = 15.sp
        )
    }
}