package data.repository

import data.dataSource.ExerciseLocalDataSource
import data.dataSource.ExerciseRemoteDataSource
import data.local.entity.DayWithExercises
import data.local.entity.Exercise
import data.response.ExerciseResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import utils.ResultWrapper

interface ExerciseRepository {
    fun getExercisesFromRemote(limit: Int): Flow<ResultWrapper<List<ExerciseResponseItem>>>
    suspend fun insertDays()
    fun getExercisesFromLocal(): Flow<List<DayWithExercises>>
    fun getDayWithExercises(dayId: Int): Flow<DayWithExercises>
    suspend fun insertExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)
}


class ExerciseRepositoryImpl(
    private val localDataSource: ExerciseLocalDataSource,
    private val remoteDataSource: ExerciseRemoteDataSource
) : ExerciseRepository {

    override fun getExercisesFromRemote(limit: Int): Flow<ResultWrapper<List<ExerciseResponseItem>>> {
        return flow {
            emit(remoteDataSource.getExercise(limit))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insertDays() = localDataSource.insertDays()

    override fun getExercisesFromLocal() = localDataSource.getExercises()

    override fun getDayWithExercises(dayId: Int) = localDataSource.getDayWithExercises(dayId)

    override suspend fun insertExercise(exercise: Exercise) =
        localDataSource.insertExercise(exercise)

    override suspend fun deleteExercise(exercise: Exercise) =
        localDataSource.deleteExercise(exercise)

}