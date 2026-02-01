package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.navigation

fun NavGraphBuilder.authNavGraph(navController: NavHostController){
    navigation(startDestination = Screen.Splash.rout, route = AUTH_GRAPH_ROUT){

    }
}