package domain.interactor

import ExerciseRepository
import data.local.entity.DayWithExercises
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ProgramInteractor(
    private val repository: ExerciseRepository
) {

    suspend fun getExercises() : Flow<List<DayWithExercises>> = repository.getExercisesFromLocal()
}