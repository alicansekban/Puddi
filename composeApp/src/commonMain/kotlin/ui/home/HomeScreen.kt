package ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import components.DaySelectionBottomSheet
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
    days:List<DayWithExercises>,
    saveExercise : () -> Unit = {}
) {
    var showDayBottomSheet by rememberSaveable {
        mutableStateOf(false)
    }
    if (showDayBottomSheet) {
        DaySelectionBottomSheet(
            days = days,
            onDismissRequest = { showDayBottomSheet = false }
        )
    }
    Card(
        modifier = modifier.fillMaxWidth().height(100.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Row(modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(
                modifier = Modifier.padding(start = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(text = "name: " + exercise.name)
                Text(text = "muscle: " + exercise.bodyPart)
            }
            Column(
                modifier = Modifier.padding(end = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Text(text = exercise.id, modifier = Modifier)
                Image(imageVector = Icons.Default.PlayArrow, contentDescription = "", modifier = Modifier.clickable {
                    showDayBottomSheet = true
                })
            }
        }
    }

}