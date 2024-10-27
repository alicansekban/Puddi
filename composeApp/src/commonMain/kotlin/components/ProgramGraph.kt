package components

import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import org.koin.compose.viewmodel.koinViewModel
import ui.program.ProgramScreen
import ui.program_detail.ProgramDetailScreen
import ui.program_detail.ProgramDetailViewModel
import utils.ProgramDetailRoute
import utils.ProgramHost
import utils.ProgramRoute

fun NavGraphBuilder.programGraph(navController: NavController) {

    navigation<ProgramHost>(
        startDestination = ProgramRoute,
    ) {
        composable<ProgramRoute> {
            ProgramScreen(
                openProgramDetail = { dayId ->
                    val route = ProgramDetailRoute(
                        dayId = dayId
                    )
                    navController.navigate(route)
                }
            )
        }
        composable<ProgramDetailRoute> {
            val args = it.toRoute<ProgramDetailRoute>()
            val viewModel = koinViewModel<ProgramDetailViewModel>()
            LaunchedEffect(true) {
                viewModel.getProgramDetail(args.dayId)
            }
            ProgramDetailScreen(
                viewModel = viewModel
            )
        }
    }
}