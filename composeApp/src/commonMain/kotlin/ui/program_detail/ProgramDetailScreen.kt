package ui.program_detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProgramDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramDetailViewModel
) {

    val dayDetail by viewModel.dayDetail.collectAsStateWithLifecycle()

    Column(modifier = modifier.fillMaxSize()) {
        dayDetail?.let { daydetail ->
            Text(text = daydetail.day.dayName)
            daydetail.exercises.forEach {
                Text(it.title)
            }
        }
    }
}