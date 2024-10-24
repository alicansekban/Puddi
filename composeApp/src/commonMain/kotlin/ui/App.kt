package ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import components.MainNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext

@Composable
@Preview
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        KoinContext {
            MainNavigation(
                navController = navController,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}