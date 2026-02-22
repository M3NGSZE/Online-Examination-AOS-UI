package com.m3ngsze.sentry.online_examination_aos_ui.feature.room

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SubHeader
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.UserCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Profile
import java.util.UUID

@Composable
fun PeopleTab(
    label: String,
    icon: ImageVector?
){
    val profile = Profile(UUID.randomUUID(), "Chanelle", "Moon", null)

    TeacherSection(profile, icon)

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    StudentSection(profile, label, icon)
}

@Composable
fun TeacherSection(
    profile: Profile,
    icon: ImageVector?
){
    Spacer(
        modifier = Modifier
            .height(10.dp)
    )

    SubHeader(
        title = "Teachers",
        icon = icon,
        font = 20.sp
    ) { }

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.LightGray
    )

    UserCard(
        profile
    )
}

@Composable
fun StudentSection(
    profile: Profile,
    label: String,
    icon: ImageVector?
){
    SubHeader(
        title = label,
        icon = icon,
        font = 20.sp
    ) { }

    HorizontalDivider(
        thickness = 1.dp,
        color = Color.LightGray
    )

    UserCard(
        profile
    )
}