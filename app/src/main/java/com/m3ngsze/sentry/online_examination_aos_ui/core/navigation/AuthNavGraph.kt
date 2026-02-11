package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.LoginScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.SignUpScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.VerifiedScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.auth.VerifyOtpScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.Splash.route, route = AUTH_GRAPH_ROUT){
        composable (route = Screen.Splash.route) { SplashScreen(navController = navController) }

        composable (route = Screen.Login.route) { LoginScreen(navController = navController) }

        composable (route = Screen.Signup.route) { SignUpScreen(navController = navController) }

        composable (
            route = Screen.VerifyOtp.route,
            arguments = listOf(navArgument(name = "email"){
                type = NavType.StringType
            })
        ) {backStackEntry ->
            val email: String? = backStackEntry.arguments?.getString(Screen.VerifyOtp.ARG_EMAIL)
            VerifyOtpScreen(navController = navController, email = email)
        }

        composable (route = Screen.Verified.route) { VerifiedScreen(navController = navController) }
    }
}