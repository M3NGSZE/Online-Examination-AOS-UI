package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun AppNavigation(navController: NavHostController){

    Scaffold (
//        containerColor = Color(0xFFF9F3E6)
        containerColor = Color(0xFFFCFCFC)
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(paddingValues = innerPadding),
            startDestination = AUTH_GRAPH_ROUT,
            navController = navController
        ){
            authNavGraph(navController = navController)
            rootNavGraph(navController = navController)
        }
    }
}