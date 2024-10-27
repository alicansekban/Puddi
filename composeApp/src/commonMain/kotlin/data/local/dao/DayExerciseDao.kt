package data.local.dao

import androidx.room.*
import data.local.entity.Day
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import kotlinx.coroutines.flow.Flow

@Dao
interface DayExerciseDao {

    // Gün ekleme
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDays(days: List<Day>) // Liste şeklinde ekleme

    @Query("SELECT COUNT(*) FROM days")
    suspend fun getDaysCount(): Int

    // Egzersiz ekleme
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    // Günün egzersizlerini çekme
    @Transaction
    @Query("SELECT * FROM days WHERE id = :dayId")
    fun getDayWithExercises(dayId: Int): Flow<DayWithExercises>

    // Tüm günleri ve onların egzersizlerini çekme
    @Transaction
    @Query("SELECT * FROM days")
    fun getAllDaysWithExercises(): Flow<List<DayWithExercises>>

    // Egzersiz silme
    @Delete
    suspend fun deleteExercise(exercise: Exercise)
}