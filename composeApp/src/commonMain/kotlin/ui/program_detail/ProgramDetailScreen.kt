package ui.program_detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.local.entity.Exercise

@Composable
fun ProgramDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramDetailViewModel
) {

    val dayDetail by viewModel.dayDetail.collectAsStateWithLifecycle()

    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.spacedBy(10.dp)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            dayDetail?.let { detail ->
                Text(
                    text = detail.day.dayName,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
        }
        HorizontalDivider(modifier = Modifier.fillMaxWidth())
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(
                dayDetail?.exercises ?: emptyList(),
                key = (({ item: Exercise -> item.id }))

            ) { item: Exercise ->
                Card(
                    modifier = modifier.fillMaxWidth().clickable {
                        viewModel.deleteExercise(exercise = item)
                    }.height(80.dp)
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(10.dp),
                    colors = CardDefaults.cardColors(Color.White)
                ) {
                    Text(item.title)
                }
            }
        }
    }
}