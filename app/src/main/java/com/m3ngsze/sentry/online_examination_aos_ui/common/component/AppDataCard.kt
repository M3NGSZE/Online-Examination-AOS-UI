package com.m3ngsze.sentry.online_examination_aos_ui.common.component

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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Exam
import com.m3ngsze.sentry.online_examination_aos_ui.domain.model.Task

@Composable
fun ExamCard(
    exam: Exam
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
                    text = exam.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    minLines = 1
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = "Posted ${exam.createdAt}",
                    color = Color.Gray,
                )

                if (exam.updatedAt!=null){
                    Spacer(
                        modifier = Modifier
                            .height(5.dp)
                    )
                    Text(
                        text = "Edited ${exam.updatedAt}",
                        color = Color.Gray,
                    )
                }
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

@Composable
fun TaskCard(
    task: Task
){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFFE3E4E8),
                shape = RoundedCornerShape(20)
            )
            .padding(15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
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
                    text = task.title,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    minLines = 1
                )

                Spacer(
                    modifier = Modifier
                        .height(10.dp)
                )

                Text(
                    text = if (task.due != null) "Due ${task.due}" else "No die date",
                    color = Color.Gray,
                )

            }
        }

        Text(
            text = task.status,
            color = if (task.status == "Assigned") Color.Gray else Color(0xFF1F7F15),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )
}