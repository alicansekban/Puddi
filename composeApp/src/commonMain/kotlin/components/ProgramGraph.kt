package components

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import utils.ProgramHost
import utils.ProgramRoute

fun NavGraphBuilder.programGraph(navController: NavController) {

    navigation<ProgramHost>(
        startDestination = ProgramRoute,
    ) {
        composable<ProgramRoute> {}
    }
}