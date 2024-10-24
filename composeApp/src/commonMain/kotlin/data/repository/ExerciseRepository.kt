import data.dataSource.ExerciseLocalDataSource
import data.dataSource.ExerciseRemoteDataSource
import data.response.ExerciseResponse
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

    fun getExercisesFromRemote(limit: Int) : Flow<ResultWrapper<ExerciseResponse>> {
        return flow {
            emit(remoteDataSource.getExercise(limit))
        }.flowOn(Dispatchers.IO)
    }
}