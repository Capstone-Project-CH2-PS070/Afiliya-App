package com.silvy.subjetpack.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object DetailItems : Screen("home/{itemsId}") {
        fun createRoute(ItemsId: Long) = "home/$ItemsId"
    }
}