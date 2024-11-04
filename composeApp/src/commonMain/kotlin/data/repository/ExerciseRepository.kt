import data.dataSource.ExerciseLocalDataSource
import data.dataSource.ExerciseRemoteDataSource
import data.local.entity.Exercise
import data.response.ExerciseResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import utils.ResultWrapper

class ExerciseRepository(
    private val localDataSource: ExerciseLocalDataSource,
    private val remoteDataSource: ExerciseRemoteDataSource
) {

    fun getExercisesFromRemote(limit: Int) : Flow<ResultWrapper<List<ExerciseResponseItem>>> {
        return flow {
            emit(remoteDataSource.getExercise(limit))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun insertDays() = localDataSource.insertDays()

     fun getExercisesFromLocal() = localDataSource.getExercises()

    fun  getDayWithExercises(dayId: Int) = localDataSource.getDayWithExercises(dayId)

    suspend fun insertExercise(exercise: Exercise) = localDataSource.insertExercise(exercise)

    suspend fun deleteExercise(exercise: Exercise) = localDataSource.deleteExercise(exercise)

}