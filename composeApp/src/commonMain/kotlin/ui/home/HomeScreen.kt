package ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinViewModel()
) {

    val homeData by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).verticalScroll(rememberScrollState())
    ) {
        when (homeData) {
            is domain.BaseUIModel.Error -> {}
            domain.BaseUIModel.Loading -> {}
            is domain.BaseUIModel.Success -> {
                val data = (homeData as domain.BaseUIModel.Success).data
                data.forEach {
                    Text(it)
                }
            }
        }
    }
}