package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.m3ngsze.sentry.online_examination_aos_ui.feature.room.RoomScreen
import com.m3ngsze.sentry.online_examination_aos_ui.feature.splash.SplashScreen

fun NavGraphBuilder.rootNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Splash.route, route = ROOT_GRAPH_ROUT){

        composable (route = Screen.Splash.route) { SplashScreen(navController = navController) }

        composable (route = Screen.Room.route) { RoomScreen(navController = navController) }
    }
}