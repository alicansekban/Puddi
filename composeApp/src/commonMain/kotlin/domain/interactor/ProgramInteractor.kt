package domain.interactor

import ExerciseRepository
import data.local.entity.DayWithExercises
import kotlinx.coroutines.flow.Flow

class ProgramInteractor(
    private val repository: ExerciseRepository
) {

    fun getDays() : Flow<List<DayWithExercises>> = repository.getExercisesFromLocal()

    fun getDayWithExercises(day: Int) : Flow<DayWithExercises> = repository.getDayWithExercises(day)
}