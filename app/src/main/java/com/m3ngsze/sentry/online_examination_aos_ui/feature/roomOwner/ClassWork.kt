package com.m3ngsze.sentry.online_examination_aos_ui.feature.roomOwner

import androidx.compose.runtime.Composable
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.UserCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Profile
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.SearchBarResult
import java.util.UUID

@Composable
fun Classwork(

){
    SearchBarResult()

    val profile = Profile(UUID.randomUUID(), "Chanelle", "Moon", null, "Assigned")

    UserCard(profile)
}