package ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import domain.BaseUIModel
import domain.interactor.HomeInteractor
import domain.model.ExerciseUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val interactor: HomeInteractor
) : ViewModel(){

    private val _uiState = MutableStateFlow<BaseUIModel<List<ExerciseUIModel>>>(BaseUIModel.Loading)
    val uiState = _uiState.stateIn(viewModelScope, SharingStarted.Eagerly, BaseUIModel.Loading)

    private val _days = MutableStateFlow<List<DayWithExercises>>(emptyList())
    val days = _days.stateIn(viewModelScope, SharingStarted.Eagerly, emptyList())

    init {
        getExercise()
        insertDays()
        getDays()
    }

    private fun getDays() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.getDays().collect{
                _days.emit(it)
            }
        }
    }

    private fun getExercise() {
        viewModelScope.launch {
            interactor.getExercises(100).collect{state ->
                _uiState.emit(state)
            }
        }
    }

    private fun insertDays() {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.insertDays()
        }
    }
     fun insertExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.insertExercise(exercise)
        }
    }
}