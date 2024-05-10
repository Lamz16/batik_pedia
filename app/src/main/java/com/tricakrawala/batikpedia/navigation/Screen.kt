package com.tricakrawala.batikpedia.navigation

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object SplashFirst : Screen("splashfirst")
    object SplashSecond : Screen("splashsecond")
    object SplashThird : Screen("splashthird")
    object ToListProvinsi : Screen("tolistprovinsi")
    object DetailProvinsi : Screen("toListProvinsi/{idNusantara}"){
        fun createRoute(idNusantara : Long) = "toListProvinsi/$idNusantara"
    }


    object Detail : Screen("home/{nusantaraId}"){
        fun createRoute(nusantaraId : String) = "home/$nusantaraId"
    }

    object Katalog : Screen("katalog")
    object Edukasi : Screen("edukasi")
    object Wisata : Screen("wisata")
}