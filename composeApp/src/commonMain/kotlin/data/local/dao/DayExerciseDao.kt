package data.local.dao

import androidx.room.*
import data.local.entity.Day
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
@Dao
interface DayExerciseDao {

    // Gün ekleme
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDay(day: Day)

    // Egzersiz ekleme
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    // Günün egzersizlerini çekme
    @Transaction
    @Query("SELECT * FROM days WHERE id = :dayId")
    suspend fun getDayWithExercises(dayId: Int): DayWithExercises

    // Tüm günleri ve onların egzersizlerini çekme
    @Transaction
    @Query("SELECT * FROM days")
    suspend fun getAllDaysWithExercises(): List<DayWithExercises>

    // Egzersiz silme
    @Delete
    suspend fun deleteExercise(exercise: Exercise)
}