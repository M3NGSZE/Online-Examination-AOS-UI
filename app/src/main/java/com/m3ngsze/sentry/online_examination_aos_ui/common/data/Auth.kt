package com.m3ngsze.sentry.online_examination_aos_ui.common.data

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.m3ngsze.sentry.online_examination_aos_ui.R

data class AuthItem(
    val id: Int,
    val name: String,
    val img: Int,
    val size: Dp
)

val AuthItemList = listOf<AuthItem>(
    AuthItem(
        id = 1,
        name = "google",
        img = R.drawable.google,
        size = 25.dp
    ),
    AuthItem(
        id = 2,
        name = "facebook",
        img = R.drawable.facebook,
        size = 40.dp
    ),
    AuthItem(
        id = 3,
        name = "github",
        img = R.drawable.github,
        size = 25.dp
    ),
)