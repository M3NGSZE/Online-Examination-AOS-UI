package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.rootNavGraph(navController: NavHostController) {
    navigation(startDestination = Screen.Splash.rout, route = ROOT_GRAPH_ROUT){

    }
}