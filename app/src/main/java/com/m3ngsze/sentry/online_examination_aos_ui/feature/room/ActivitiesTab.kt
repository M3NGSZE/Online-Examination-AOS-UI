package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.runtime.Composable
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.ExamCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Exam
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.SearchBarResult
import java.util.UUID

@Composable
fun ActivityTab(

){
    SearchBarResult()

    val exam = Exam(examId = UUID.randomUUID(), title = "Math Exam")
    exam.createdAt = "2026-02-20"
//    exam.updatedAt = "2026-02-20"

    ExamCard(
        exam
    )
}