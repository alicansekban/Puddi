package domain.interactor

import ExerciseRepository
import data.local.entity.DayWithExercises
import domain.BaseUIModel
import domain.mapper.toUIModel
import domain.model.ExerciseUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeInteractor(
    private val repository: ExerciseRepository
) {

    fun getExercises(limit: Int): Flow<BaseUIModel<List<ExerciseUIModel>>> {
        return flow {
            emit(BaseUIModel.Loading)
            repository.getExercisesFromRemote(limit).collect{state ->
                when (state) {
                    is utils.ResultWrapper.GenericError -> emit(BaseUIModel.Error(message = state.error ?: ""))
                    is utils.ResultWrapper.Success -> {
                        val exercises = state.value.map {
                            it.toUIModel()
                        }
                        emit(BaseUIModel.Success(exercises))
                    }
                }
            }
        }
    }
    suspend fun insertDays() {
        repository.insertDays()
    }

     fun getDays(): Flow<List<DayWithExercises>> {
        return repository.getExercisesFromLocal()
    }
}