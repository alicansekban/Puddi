package data.dataSource

import data.local.AppDatabase
import data.local.entity.Day
import data.local.entity.DayWithExercises
import kotlinx.coroutines.flow.Flow

class ExerciseLocalDataSource(
    private val db : AppDatabase
) {

    suspend fun insertDays() {
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

    suspend fun getExercises() : Flow<List<DayWithExercises>> {
        return db.getDao().getAllDaysWithExercises()
    }

}
