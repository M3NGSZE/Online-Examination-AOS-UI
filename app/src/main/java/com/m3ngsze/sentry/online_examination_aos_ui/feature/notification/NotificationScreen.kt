package com.m3ngsze.sentry.online_examination_aos_ui.feature.notification

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.HeaderArrowBack
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun NotificationScreen(
    navController: NavHostController,
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {
        HeaderArrowBack (
            title = "Notifications"
        ){
            navController.navigate(Screen.Room.route)
        }
    }
}