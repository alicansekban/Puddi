package components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import ui.home.HomeScreen
import utils.HomeHost
import utils.HomeRoute

fun NavGraphBuilder.homeGraph(navController: NavController) {

    navigation<HomeHost>(
        startDestination = HomeRoute,
    ) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}