package data.dataSource

import data.remote.ExerciseApiService
import data.response.ExerciseResponseItem
import utils.ResultWrapper

interface ExerciseRemoteDataSource {
    suspend fun getExercise(limit : Int) : ResultWrapper<List<ExerciseResponseItem>>
}
class ExerciseRemoteDataSourceImpl(
    private val apiService: ExerciseApiService
) : ExerciseRemoteDataSource{
   override suspend fun getExercise(limit : Int) = apiService.getExerciseList(limit)
}
