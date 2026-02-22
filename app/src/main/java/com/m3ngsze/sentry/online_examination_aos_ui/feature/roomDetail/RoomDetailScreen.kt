package com.m3ngsze.sentry.online_examination_aos_ui.feature.roomDetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.BottomNavigation
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SubHeader
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.room.ActivityTab
import com.m3ngsze.sentry.online_examination_aos_ui.feature.room.ClassworkTab
import com.m3ngsze.sentry.online_examination_aos_ui.feature.room.PeopleTab

@Composable
fun RoomDetailScreen(
    navController: NavHostController,
){
    var indexTab by remember { mutableIntStateOf(2) }

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
                font = 26.sp
            ) {
                navController.navigate(Screen.RoomInfo.route)
            }

            when(indexTab){
                0 -> ActivityTab()
                1 -> ClassworkTab()
                2 -> PeopleTab(label = "Classmates",icon = null)
            }
        }

        BottomNavigation {
            indexTab = it
        }
    }
}