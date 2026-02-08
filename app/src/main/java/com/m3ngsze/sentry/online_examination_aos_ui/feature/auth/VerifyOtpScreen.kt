package com.m3ngsze.sentry.online_examination_aos_ui.feature.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.R
import com.m3ngsze.sentry.online_examination_aos_ui.common.component.SmallTextField
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen

@Composable
fun VerifyOtpScreen(
    navController: NavHostController,
    viewModel: AuthViewModel = hiltViewModel(),
    email: String?
){
    Column (
        modifier = Modifier
            .padding(start = 25.dp, bottom = 25.dp, end = 25.dp)
            .background(Color(0xFFFCFCFC))
            .fillMaxWidth()
    ) {
        HeaderOtp(navController = navController)

        OtpForm(
            viewModel = viewModel,
            email = email
        )
    }

    val verifyState = viewModel.verifyState
    LaunchedEffect(verifyState) {
        if (verifyState !=null){
            navController.navigate(Screen.Login.route)
        }
    }

}

@Composable
fun HeaderOtp(navController: NavHostController){

    Box (
        modifier = Modifier
            .padding(vertical = 3.dp)
            .clickable{
                navController.navigate(Screen.Signup.route)
            }
    ){
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back to register",
            tint = Color.Black
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ){
        Image(
            painter = painterResource(id = R.drawable.otp),
            contentDescription = "Otp icon",
            modifier = Modifier
                .align(Alignment.Center)
                .size(130.dp)
        )
    }

    Spacer(
        modifier = Modifier
            .height(18.dp)
    )

    Text(
        text = "Verify Your Email Address",
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 23.sp,
        modifier = Modifier
            .fillMaxWidth()
    )

    Spacer(
        modifier = Modifier
            .height(13.dp)
    )

    Text(
        text = "Enter your OTP code here",
        textAlign = TextAlign.Center,
        fontSize = 15.sp,
        fontWeight = FontWeight.SemiBold,
        color = Color(0xD07D7D7D),
        modifier = Modifier
            .fillMaxWidth()
    )

    Spacer(
        modifier = Modifier
            .height(18.dp)
    )

}

@Composable
fun OtpForm(
    viewModel: AuthViewModel = hiltViewModel(),
    email: String?
){
    val otpList = remember {
        mutableStateListOf("", "", "", "", "", "")
    }

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ){

        otpList.forEachIndexed { index, value ->

            SmallTextField(
                w = 55.dp,
                h = 65.dp,
            ) { input ->
                otpList[index] = input   // update only this box
            }
        }
    }

    val otpCode = otpList.joinToString("")

    Spacer(
        modifier = Modifier
            .height(28.dp)
    )

    Button(
        onClick = {
            viewModel.verifyOtp(email, otpCode)
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
            text = "Verify Email",
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
    }

    Spacer(
        modifier = Modifier
            .height(15.dp)
    )

    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFAFAFA)
        ),
    ) {
        Text(
            text = "Resend Code",
            fontWeight = FontWeight.Medium,
            color = Color.Black,
            style = TextStyle(
                textDecoration = TextDecoration.Underline
            )
        )
    }

}