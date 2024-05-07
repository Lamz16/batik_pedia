package com.tricakrawala.batikpedia.navigation

sealed class Screen(val route : String) {

    object SplashFirst : Screen("splashfirst")
    object SplashSecond : Screen("splashsecond")
    object SplashThird : Screen("splashthird")
}