package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.LoginScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.SignUpScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.VerifyOtpScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.VerifyOtp.route, route = AUTH_GRAPH_ROUT){
        composable (route = Screen.Splash.route) { SplashScreen(navController = navController) }

        composable (route = Screen.Login.route) { LoginScreen(navController = navController) }

        composable (route = Screen.Signup.route) { SignUpScreen(navController = navController) }

        composable (route = Screen.VerifyOtp.route) { VerifyOtpScreen(navController = navController) }
    }
}