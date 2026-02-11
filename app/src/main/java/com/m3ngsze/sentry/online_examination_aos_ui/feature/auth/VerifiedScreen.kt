package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun VerifiedScreen(
    navController : NavHostController
){
    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
            .fillMaxWidth()
    ) {

        VerifiedHeader(navController)

        VerifiedBody(navController)
    }
}

@Composable
fun VerifiedHeader(
    navController : NavHostController
){
    Box (
        modifier = Modifier
            .padding(vertical = 3.dp)
                .clickable{
                    navController.navigate(Screen.VerifyOtp.route)
                }
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back to verify otp",
            tint = Color.Black
        )
    }

    Spacer(
        modifier = Modifier
        .height(100.dp)
    )


}

@Composable
fun VerifiedBody(
    navController : NavHostController
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        AsyncImage(
            model = R.drawable.verified,
            contentDescription = "Otp icon",
            modifier = Modifier
                .align(Alignment.Center)
                .size(200.dp)
        )
    }

    Spacer(
        modifier = Modifier
            .height(40.dp)
    )

    Text(
        modifier = Modifier
            .fillMaxWidth(),
        textAlign = TextAlign.Center,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 35.sp,
        text = """
            |Email Verified 
            |Successfully
            |""".trimMargin()
    )

    Spacer(
        modifier = Modifier
            .height(100.dp)
    )

    Button(
        onClick = {
            navController.navigate(Screen.Login.route)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp)
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(25),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF1E319C)
        ),
    ) {
        Text(
            text = "Back to Login",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}