package domain.interactor

import data.repository.ExerciseRepository
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import kotlinx.coroutines.flow.Flow

class ProgramInteractor(
    private val repository: ExerciseRepository
) {

    fun getDays() : Flow<List<DayWithExercises>> = repository.getExercisesFromLocal()

    fun getDayWithExercises(day: Int) : Flow<DayWithExercises> = repository.getDayWithExercises(day)

    suspend fun deleteExercise(exercise: Exercise) = repository.deleteExercise(exercise)
}