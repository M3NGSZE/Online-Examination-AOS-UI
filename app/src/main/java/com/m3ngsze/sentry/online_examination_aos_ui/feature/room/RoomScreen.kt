package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.ProfileViewModel
import com.m3ngsze.sentry.online_examination_aos_ui.R

@Composable
fun RoomScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel()
){

    LaunchedEffect (Unit) {
        viewModel.getUserProfile()
    }

    Column (
        modifier = Modifier
            .padding(start = 40.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
    ){
        HeaderRoom(
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun HeaderRoom(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel()
){
    val user = viewModel.userState

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
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF006FB7)
            )

            Text(
                text = " Pilot",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFFF78203)
            )
        }


        Row (
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Box (
                modifier = Modifier
                    .size(40.dp)
                    .background(
                        Color.Gray,
                        shape = CircleShape
                    )
            ){
                AsyncImage(
                    model = user?.profileUrl ?: R.drawable.profile,
                    contentDescription = "profile img",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            }

            Box {
                Icon(
                    imageVector = Icons.Default.NotificationsNone,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(start = 15.dp)
                        .size(25.dp)
                )
            }
        }
    }
}