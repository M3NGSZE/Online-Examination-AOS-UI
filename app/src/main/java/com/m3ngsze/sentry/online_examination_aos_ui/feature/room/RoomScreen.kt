package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun RoomScreen(navController: NavHostController){
    ForPreview()
}

@Composable
@Preview
fun ForPreview(){
    Column (
        modifier = Modifier
            .padding(start = 40.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
    ){
        HeaderRoom()
    }
}

@Composable
fun HeaderRoom(){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row (
            modifier = Modifier
                .fillMaxHeight(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Exam",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = "  Pilot",
                fontSize = 18.sp,
                color = Color(0xD049494A)
            )
        }


        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box (
                modifier = Modifier
                    .size(35.dp)
                    .background(
                        Color.Gray,
                        shape = CircleShape
                    )
            ){

            }

            Box {
                Icon(
                    imageVector = Icons.Default.MoreHoriz,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(20.dp)
                )
            }
        }
    }
}