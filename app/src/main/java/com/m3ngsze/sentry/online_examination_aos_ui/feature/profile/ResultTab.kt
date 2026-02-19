package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SearchBox

@Composable
fun ResultTab(

){
    SearchBarResult()
    ResultCard()
    ResultCard()
}

@Composable
fun SearchBarResult(

){

    var search by remember { mutableStateOf("") }

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        SearchBox (
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .height(50.dp),
            label = "Search",
            outline = Color(0x73919090),
        ) { search = it}

        Icon(
            imageVector = Icons.Default.Tune,
            contentDescription = "filter"
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )
}

@Composable
fun ResultCard(

){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE3E4E8),
                shape = RoundedCornerShape(20)
            )
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(15.dp),
        ){
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Assignment,
                contentDescription = "Assignment"
            )

            Column {
                Text(
                    text = "Result: ",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    minLines = 1
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "67, July, 6767",
                    color = Color.Gray,
                )
            }
        }

        Icon(
            imageVector = Icons.Default.MoreHoriz,
            contentDescription = "More option",
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )
}