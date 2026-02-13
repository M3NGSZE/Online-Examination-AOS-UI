package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Edit
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
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel()
){
//    LaunchedEffect (Unit) {
//        viewModel.getUserProfile()
//    }

    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
            .fillMaxWidth()
    ){
        ProfileHeader(
            navController = navController
        )

        ProfileInfo(
            navController = navController,
            viewModel = viewModel
        )
    }
}

@Composable
fun ProfileHeader(
    navController: NavHostController,
){
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            imageVector = Icons.Default.ArrowBackIosNew,
            contentDescription = "Back to exam screen",
            modifier = Modifier
//                .clickable{
//                    navController.navigate(Screen.Room.route)
//                }
        )

        Text(
            text = "My Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 19.sp
        )

        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = "Edit personal info"
        )
    }

    Spacer(
        modifier = Modifier
            .height(30.dp)
    )
}

@Composable
fun ProfileInfo(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel()
){
    val user = viewModel.userState
    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .background(Color.Gray, CircleShape)
        ) {
            AsyncImage(
                model = user?.profileUrl
                    ?: R.drawable.profile,
                contentDescription = "profile img",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )
        }

        Spacer(
            modifier = Modifier
                .width(20.dp)
        )

        Column {
            Text(
                text = """
                    ${user?.lastName ?: "Last Name" }
                    ${user?.firstName ?: "First Name" }
                """.trimIndent(),
                fontWeight = FontWeight.SemiBold,
                fontSize = 23.sp,
                lineHeight = 30.sp
            )

            Spacer(
                modifier = Modifier
                    .height(10.dp)
            )

            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column {
                    Text(
                        text = "N/A",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )

                    Text(
                        text = "GENDER",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF959595)
                    )
                }

                Column {
                    Text(
                        text = "67",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )

                    Text(
                        text = "AGE",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF959595)
                    )
                }

                Column {
                    Text(
                        text = "67/67/6767",
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    )

                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )

                    Text(
                        text = "BIRTHDAY",
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        color = Color(0xFF959595)
                    )
                }
            }
        }
    }

    Spacer(
        modifier = Modifier
            .height(30.dp)
    )
}