package com.m3ngsze.sentry.online_examination_aos_ui.common.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WarningAmber
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InvalidInput(msg: String?){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.Red, shape = RoundedCornerShape(5.dp))
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Icon(
            imageVector  = Icons.Default.WarningAmber,
            contentDescription = "",
            tint = Color.Red,
            modifier = Modifier
                .size(20.dp)
        )

        Spacer(
            modifier = Modifier
                .width(10.dp)
        )

        Text(
            text = """
            $msg
            Please try again!
        """.trimIndent(),
            color = Color.Red,
            lineHeight = 20.sp
        )
    }
}