package com.example.ironasia

import androidx.navigation.NavHostController

sealed class IronAsiaRoutes(val route: String) {
    object Login : IronAsiaRoutes("login")

    object Home : IronAsiaRoutes("home")

    object Form : IronAsiaRoutes("form")

    object Detail : IronAsiaRoutes("detail/{userId}") {
        fun createRoute(userId: String) = "detail/$userId"
    }
}

class IronAsiaNavigationActions(private val navController: NavHostController) {
    fun navigateTo(routes: String) {
        navController.navigate(routes) {
            if (routes == IronAsiaRoutes.Login.route || routes == IronAsiaRoutes.Home.route) {
                popUpTo(navController.graph.id) { inclusive = true }
                launchSingleTop = true
                restoreState = false
            }
        }
    }
}