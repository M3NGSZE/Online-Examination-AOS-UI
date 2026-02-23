package com.m3ngsze.sentry.online_examination_aos_ui.feature.roomOwner

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.AppDatePicker
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.HeaderArrowBack
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.RequireIcon
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.TextBox
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.TextBoxDatPicker
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun CreateExamScreen(
    navController: NavHostController
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ) {
        HeaderArrowBack (
            title = "Create Exam",
        ) {
            navController.navigate(Screen.RoomOwner.route)
        }

        CreateExamForm()
    }
}

@Composable
fun CreateExamForm(

){
    var title by remember { mutableStateOf("") }
    var subject by remember { mutableStateOf("") }
    var scheduleDate: String? by remember { mutableStateOf("") }
    var startAt : String? by remember { mutableStateOf("") }
    var endAt :String? by remember { mutableStateOf("") }

    TextBox(
      label = "Title",
      outline = Color(0x73919090),
      trailIcon = { RequireIcon() }
    ) { title = it }

    TextBox(
        label = "Subject",
        outline = Color(0x73919090),
        trailIcon = { RequireIcon() }

    ) { subject = it }

    TextBoxDatPicker(
        label = "Set up schedule",
        outline = Color(0x73919090),
        trailIcon = { AppDatePicker { scheduleDate = it} },
        y = scheduleDate
    )
}
