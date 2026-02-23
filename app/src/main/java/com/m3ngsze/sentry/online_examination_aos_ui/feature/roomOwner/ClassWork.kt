package com.m3ngsze.sentry.online_examination_aos_ui.feature.roomOwner

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.UserCard
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Profile
import com.m3ngsze.sentry.online_examination_aos_ui.feature.profile.SearchBarResult
import java.util.UUID

@Composable
fun Classwork(

){
    SearchBarResult()

    val profile = Profile(UUID.randomUUID(), "Chanelle", "Moon", null, "Assigned")

    Section(profile)
    Section(profile)

}

@Composable
fun Section(
    profile: Profile
){
    var hide by remember { mutableStateOf(false) }

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "Assignment Title",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp
        )

        Icon(
            imageVector = if (hide) Icons.Default.ArrowDropUp else Icons.Default.ArrowDropDown,
            contentDescription = "Hide and Seek",
            modifier = Modifier
                .clickable{
                    hide = !hide
                }
        )
    }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp, vertical = 8.dp)
    ){
        if (hide)
            UserCard(profile)
    }
}