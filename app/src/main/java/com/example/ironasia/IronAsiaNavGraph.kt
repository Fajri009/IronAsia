package com.example.ironasia

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ironasia.ui.module.contact.detail.DetailContactScreen
import com.example.ironasia.ui.module.form.FormScreen
import com.example.ironasia.ui.module.home.HomeScreen
import com.example.ironasia.ui.module.login.LoginScreen
import com.example.ironasia.viewmodel.contact.detail.DetailContactViewModel
import com.example.ironasia.viewmodel.form.FormViewModel
import com.example.ironasia.viewmodel.home.HomeViewModel

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
        val navigateHome = { navActions.navigateTo(IronAsiaRoutes.Home.route) }
        val navigateForm = { navActions.navigateTo(IronAsiaRoutes.Form.route) }
        val navigateDetail = { id: String ->
            navActions.navigateTo(IronAsiaRoutes.Detail.createRoute(id))
        }

        composable(route = IronAsiaRoutes.Login.route) {
            LoginScreen(navigateHome = navigateHome)
        }

        composable(route = IronAsiaRoutes.Home.route) {
            val viewModel = hiltViewModel<HomeViewModel>()

            HomeScreen(
                viewModel = viewModel,
                navigateForm = navigateForm,
                navigateDetail = navigateDetail
            )
        }

        composable(route = IronAsiaRoutes.Form.route) {
            val viewModel = hiltViewModel<FormViewModel>()

            FormScreen(
                viewModel = viewModel,
                navigateBack = navigateHome
            )
        }

        composable(
            route = IronAsiaRoutes.Detail.route,
            arguments =
                listOf(
                    navArgument("userId") { type = NavType.StringType },
                )
        ) { navBackStackEntry ->
            val userId = navBackStackEntry.arguments?.getString("userId")

            val viewModel = hiltViewModel<DetailContactViewModel>()

            DetailContactScreen(
                viewModel = viewModel,
                userId = userId ?: "",
                navigateBack = navigateHome
            )
        }
    }
}