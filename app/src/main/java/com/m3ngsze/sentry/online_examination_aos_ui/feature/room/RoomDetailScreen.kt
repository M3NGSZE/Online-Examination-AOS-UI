package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PendingActions
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Task
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SubHeader

@Composable
fun RoomDetailScreen(
    navController: NavHostController,
){
    var indexTab by remember { mutableIntStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 25.dp)
        ) {
            SubHeader(
                title = "RoomName",
                icon = Icons.Default.Info,
                font = 23.sp
            ) { }

            when(indexTab){
                0 -> ActivityTab()
                1 -> ClassworkTab()
                2 -> PeopleTab()
            }
        }

        BottomNavigation()
    }
}

@Composable
fun BottomNavigation(

){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE4E5E9),
                shape = RoundedCornerShape(20)
            )
            .padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){
        NavigationItem(
            title = "Activities",
            icon = Icons.Default.Task
        )

        NavigationItem(
            title = "Classwork",
            icon = Icons.Default.PendingActions
        )

        NavigationItem(
            title = "People",
            icon = Icons.Default.People
        )
    }
}

@Composable
fun NavigationItem(
    title: String,
    icon: ImageVector
){
    Column (
        modifier = Modifier,
//            .background(
//                color = Color.Gray
//            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Icon(
            imageVector = icon,
            contentDescription = "Activities"
        )

        Spacer(
            modifier = Modifier
                .height(6.dp)
        )

        Text(
            text = title
        )
    }
}