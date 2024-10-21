package data.dataSource

import data.remote.ExerciseApiService
import data.response.ExerciseResponse
import kotlinx.coroutines.Dispatchers
import utils.ResultWrapper
import utils.safeApiCall


class ExerciseRemoteDataSource(
    private val apiService: ExerciseApiService
) {
   suspend fun getExercise(limit : Int) : ResultWrapper<ExerciseResponse> = apiService.getExerciseList(limit)
}
