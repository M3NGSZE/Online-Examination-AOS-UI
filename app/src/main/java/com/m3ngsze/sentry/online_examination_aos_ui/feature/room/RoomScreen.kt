package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NotificationsNone
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SearchBox
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.AuthViewModel

@Composable
fun RoomScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel(),
) {

    LaunchedEffect(Unit) {
        viewModel.getUserProfile()
    }

    Column(
        modifier = Modifier
            .padding(25.dp, end = 25.dp, top = 0.dp)
            .background(Color(0xFFFCFCFC))
    ) {

        HeaderRoom(
            navController = navController,
            viewModel = viewModel,
            authViewModel = authViewModel
        )

        RoomBody(
            navController = navController
        )
    }


    val logout = authViewModel.logoutState
    LaunchedEffect(logout) {
        if (logout == true) {
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Room.route) { inclusive = true }
            }
        }
    }
}


@Composable
fun HeaderRoom(
    navController: NavHostController,
    viewModel: ProfileViewModel  = hiltViewModel(),
    authViewModel: AuthViewModel = hiltViewModel(),
){
    val user = viewModel.userState
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Exam",
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF006FB7)
            )

            Text(
                text = " Pilot",
                fontSize = 19.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFF78203)
            )
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column(
                horizontalAlignment = Alignment.End
            ) {

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(Color.Gray, CircleShape)
                        .clickable {
                            expanded = !expanded
                        }
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

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {

                    DropdownMenuItem(
                        text = { Text("Profile") },
                        onClick = {
                            expanded = false
                            navController.navigate(Screen.Profile.route)
                        }
                    )

                    DropdownMenuItem(
                        text = { Text("Setting") },
                        onClick = { expanded = false }
                    )

                    DropdownMenuItem(
                        text = { Text("Logout") },
                        onClick = {
                            expanded = false
                            authViewModel.logout()
                        }
                    )
                }
            }
            Icon(
                imageVector = Icons.Default.NotificationsNone,
                contentDescription = "Notification",
                modifier = Modifier
                    .padding(start = 15.dp)
                    .size(25.dp)
            )
        }
    }
}

@Composable
fun RoomBody(
    navController: NavHostController,
){

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    var search by remember { mutableStateOf("") }

    SearchBox (
        modifier = Modifier
            .fillMaxWidth(0.9f)
            .height(50.dp),
        label = "Search",
        outline = Color(0x73919090),
        getValue = {search = it}
    ) { }
}