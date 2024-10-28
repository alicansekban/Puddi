package ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.local.entity.DayWithExercises
import domain.model.ExerciseUIModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeScreenViewModel = koinViewModel()
) {

    val homeData by viewModel.uiState.collectAsStateWithLifecycle()
    val days by viewModel.days.collectAsStateWithLifecycle()
    Column(
        modifier = Modifier.fillMaxSize().background(Color.White)
            .verticalScroll(rememberScrollState())
    ) {
        when (homeData) {
            is domain.BaseUIModel.Error -> {}
            domain.BaseUIModel.Loading -> {}
            is domain.BaseUIModel.Success -> {
                val data = (homeData as domain.BaseUIModel.Success).data
                data.forEach {
                    ExerciseListItem(
                        exercise = it,
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 8.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.Gray)
                            .fillMaxWidth(),
                        days = days

                    )
                }
            }
        }
    }
}

@Composable
fun ExerciseListItem(
    modifier: Modifier = Modifier,
    exercise: ExerciseUIModel,
    days:List<DayWithExercises>
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        Column(modifier=Modifier.padding(start = 8.dp),verticalArrangement = Arrangement.spacedBy(10.dp)) {

            Text(text = "name: " + exercise.name)
            Text(text = "muscle: " + exercise.bodyPart)
        }
        Text(text = exercise.id, modifier = Modifier.padding(end = 8.dp))
    }

}