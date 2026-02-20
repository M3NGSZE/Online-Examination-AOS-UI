package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.runtime.Composable
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.TaskCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Task
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.SearchBarResult
import java.util.UUID

@Composable
fun ClassworkTab(

){
    SearchBarResult()

    val task = Task(examId = UUID.randomUUID(), title = "Math Exam", due = null, status = "Turn")

    TaskCard(
        task
    )
}