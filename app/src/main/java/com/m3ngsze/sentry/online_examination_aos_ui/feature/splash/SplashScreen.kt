package com.m3ngsze.sentry.online_examination_aos_ui.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.m3ngsze.sentry.online_examination_aos_ui.core.navigation.Screen
import com.m3ngsze.sentry.online_examination_aos_ui.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){

    LaunchedEffect (Unit){
        delay(2000)
        navController.navigate(Screen.Login.rout){
            popUpTo (Screen.Splash.rout){ inclusive = true }
        }
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier.size(200.dp)
        )

        Spacer(
            modifier = Modifier.width(10.dp)
        )

        Text(
            text = "Online-Examination",
            color = Color(0xFF1EA2B2),
            fontSize = 30.sp)
    }

}