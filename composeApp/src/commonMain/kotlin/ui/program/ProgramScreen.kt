package ui.program

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import data.local.entity.DayWithExercises
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ProgramScreen(
    modifier: Modifier = Modifier,
    viewModel: ProgramViewModel = koinViewModel(),
    openProgramDetail: (dayId: Int) -> Unit
) {

    val days by viewModel.days.collectAsStateWithLifecycle()
    Column(modifier = modifier.verticalScroll(rememberScrollState()).fillMaxSize().background(Color.White)) {
        days.forEach { day ->
            ProgramDayItem(day = day, openProgramDetail = openProgramDetail)
        }
    }
}

@Composable
fun ProgramDayItem(
    modifier: Modifier = Modifier,
    day: DayWithExercises,
    openProgramDetail: (dayId: Int) -> Unit
) {

    Card(
        modifier = modifier.fillMaxWidth().clickable { openProgramDetail.invoke(day.day.id) }.height(100.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            Text(day.day.dayName)
        }
    }

}