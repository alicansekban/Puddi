package domain.interactor

import ExerciseRepository
import domain.BaseUIModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class HomeInteractor(
    private val repository: ExerciseRepository
) {

    fun getExercises(limit: Int): Flow<BaseUIModel<List<String>>> {
        return flow {
            emit(BaseUIModel.Loading)
            repository.getExercisesFromRemote(limit).collect{state ->
                when (state) {
                    is utils.ResultWrapper.GenericError -> emit(BaseUIModel.Error(message = state.error ?: ""))
                    is utils.ResultWrapper.Success -> {
                        val exercises = state.value.map {
                            it.name ?: ""
                        }
                        emit(BaseUIModel.Success(exercises))
                    }
                }
            }
        }
    }
}