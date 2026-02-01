package com.m3ngsze.sentry.online_examination_aos_ui.core.navigation

const val ROOT_GRAPH_ROUT = "root"

const val AUTH_GRAPH_ROUT = "auth"

sealed class Screen(val rout: String, val title: String) {

    object Splash: Screen("splash_screen", "splash")

    object Login: Screen("login_screen", "login")

    object Signup: Screen("signup_screen", "signup")

    object Home: Screen("Home_screen", "Home")

}