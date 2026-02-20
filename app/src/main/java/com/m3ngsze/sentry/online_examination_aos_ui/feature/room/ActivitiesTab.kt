package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.runtime.Composable
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.RowCard
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.SearchBarResult
import java.util.UUID

@Composable
fun ActivityTab(

){
    SearchBarResult()

    RowCard(
        id = UUID.randomUUID(),
        title = "Math Exam",
        create = "2026-02-20",
        update = null
    )

    RowCard(
        id = UUID.randomUUID(),
        title = "Math Exam",
        create = "2026-02-20",
        update = null
    )
}