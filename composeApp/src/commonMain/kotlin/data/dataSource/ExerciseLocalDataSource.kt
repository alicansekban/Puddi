package data.dataSource

import data.local.AppDatabase
import data.local.entity.Day
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import kotlinx.coroutines.flow.Flow

interface ExerciseLocalDataSource {
    suspend fun insertDays()
    fun getExercises() : Flow<List<DayWithExercises>>
    fun getDayWithExercises(dayId : Int) : Flow<DayWithExercises>
    suspend fun insertExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)

}

class ExerciseLocalDataSourceImp(
    private val db : AppDatabase
) : ExerciseLocalDataSource {

    override suspend fun insertDays() {
        val daysCount = db.getDao().getDaysCount()

        if (daysCount == 0) { // Eğer gün yoksa
            val days = listOf(
                Day(dayName = "Monday"),
                Day(dayName = "Tuesday"),
                Day(dayName = "Wednesday"),
                Day(dayName = "Thursday"),
                Day(dayName = "Friday"),
                Day(dayName = "Saturday"),
                Day(dayName = "Sunday")
            )
            db.getDao().insertDays(days) // Günleri ekle
        }
    }

    override fun getExercises() : Flow<List<DayWithExercises>> {
        return db.getDao().getAllDaysWithExercises()
    }

    override fun getDayWithExercises(dayId : Int) : Flow<DayWithExercises> {
        return db.getDao().getDayWithExercises(dayId)
    }

    override suspend fun insertExercise(exercise: Exercise) {
        db.getDao().insertExercise(exercise)
    }

    override suspend fun deleteExercise(exercise: Exercise) {
        db.getDao().deleteExercise(exercise)
    }

}
