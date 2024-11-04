package ui.program_detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import domain.interactor.ProgramInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProgramDetailViewModel(
    private val interactor: ProgramInteractor
) : ViewModel() {

    private val _dayDetail = MutableStateFlow<DayWithExercises?>(null)
    val dayDetail = _dayDetail.asStateFlow()

    fun getProgramDetail(id: Int) {
         viewModelScope.launch(Dispatchers.IO) {
             interactor.getDayWithExercises(id).collect{
                 _dayDetail.emit(it)
             }
         }
    }

    fun deleteExercise(exercise: Exercise) {
        viewModelScope.launch(Dispatchers.IO) {
            interactor.deleteExercise(exercise)
        }
    }
}