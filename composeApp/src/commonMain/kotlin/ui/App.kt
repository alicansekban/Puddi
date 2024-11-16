package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import components.AppTopBar
import components.BottomBar
import components.MainNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        KoinContext {
            Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                BottomBar(navController = navController, isBottomBarVisible = true)
            },
                topBar = {
                    AppTopBar(
                        modifier = Modifier.fillMaxWidth(),
                        title = "Deneme",
                        onBackClick = {navController.popBackStack()}
                    )
                }
            ) {paddingValues ->
                MainNavigation(
                    navController = navController,
                    modifier = Modifier.fillMaxSize().padding(paddingValues)
                )
            }

        }
    }
}