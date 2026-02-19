package com.m3ngsze.sentry.online_examination_aos_ui.feature.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.StatCardLarge
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.StatCardSmall
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.StatItem
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SubHeader

@Composable
fun StatsTab(){
    TeachingStats()
    StudyStats()
}

@Composable
fun TeachingStats() {

    Column(modifier = Modifier.fillMaxWidth()) {

        SubHeader(
            title = "Teaching Stats",
            icon = Icons.Default.Tune,
        ) { }

        // Top cards
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            StatCardLarge(
                number = "67",
                label = "All Students",
                modifier = Modifier.weight(1f),
                fontSize = 30.sp,
                textSize = 15.sp
            )

            StatCardLarge(
                number = "12",
                label = "All Rooms",
                modifier = Modifier.weight(1f),
                fontSize = 30.sp,
                textSize = 15.sp
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Bottom stats container
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE4E5E9),
                    shape = RoundedCornerShape(20)
                )
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            StatItem("67", "Total Exam")
            StatItem("10", "Upcoming Exam")
            StatItem("57", "Total Submit")
        }

        Spacer(modifier = Modifier.height(20.dp))
    }
}

@Composable
fun StudyStats() {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {

        SubHeader(
            title = "Exam Stats",
            icon = Icons.Default.Tune,
        ) { }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(190.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            // Left Big Card (full height)
            StatCardLarge(
                number = "67",
                label = "Total Score",
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                fontSize = 50.sp,
                textSize = 20.sp
            )

            // Right Small Cards
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {

                StatCardSmall(
                    number = "67",
                    label = "Total Rooms",
                    modifier = Modifier
                        .weight(1f)
                )

                StatCardSmall(
                    number = "67",
                    label = "Average Score",
                    modifier = Modifier
                        .weight(1f)
                )
            }
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Bottom stats container
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE4E5E9),
                    shape = RoundedCornerShape(20)
                )
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            StatItem("67", "Total Exam")
            StatItem("67", "Upcoming Exam")
            StatItem("67", "Total Submit")
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}