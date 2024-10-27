package ui.program

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProgramScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramViewModel = koinViewModel(),
) {

    val days by viewModel.days.collectAsStateWithLifecycle()
    Column(modifier = modifier.fillMaxSize().background(Color.White)) {
        days.forEach { day ->
            Text(text = day.day.dayName)
        }
    }
}