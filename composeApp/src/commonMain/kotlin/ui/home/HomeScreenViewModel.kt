package ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.BaseUIModel
import domain.interactor.HomeInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val interactor: HomeInteractor
) : ViewModel(){

    private val _uiState = MutableStateFlow<BaseUIModel<List<String>>>(BaseUIModel.Loading)
    val uiState = _uiState.stateIn(viewModelScope, SharingStarted.Eagerly, BaseUIModel.Loading)

    init {
        getExercise()
        insertDays()
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
}