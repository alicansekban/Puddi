package ui.program

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.local.entity.DayWithExercises
import domain.interactor.ProgramInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProgramViewModel(
    private val interactor: ProgramInteractor
) : ViewModel(){
    private val _days = MutableStateFlow<List<DayWithExercises>>(emptyList())
    val days = _days.asStateFlow()

    init {
        getDays()
    }

    private fun getDays() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getExercises().collect{daysList ->
                _days.emit(daysList)
            }
        }
    }
}