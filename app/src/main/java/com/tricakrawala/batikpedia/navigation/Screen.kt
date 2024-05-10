package com.tricakrawala.batikpedia.navigation

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object SplashFirst : Screen("splashfirst")
    object SplashSecond : Screen("splashsecond")
    object SplashThird : Screen("splashthird")
    object ToListProvinsi : Screen("tolistprovinsi")
    object Berita : Screen("berita")
    object DetailProvinsi : Screen("toListProvinsi/{idNusantara}"){
        fun createRoute(idNusantara : Long) = "toListProvinsi/$idNusantara"
    }


    object Katalog : Screen("katalog")

    object DetailBatik : Screen("katalog/{idBatik}"){
        fun createRoute(idBatik : Long) = "katalog/$idBatik"
    }
    object Edukasi : Screen("edukasi")
    object Wisata : Screen("wisata")
}