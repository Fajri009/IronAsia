package com.example.ironasia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ironasia.ui.module.login.LoginScreen

@Composable
fun IronAsiaNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = IronAsiaRoutes.Login.route,
    navActions: IronAsiaNavigationActions =
        remember(navController) { IronAsiaNavigationActions(navController) }
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(route = IronAsiaRoutes.Login.route) {
            LoginScreen()
        }
    }
}