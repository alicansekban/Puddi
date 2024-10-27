package data.dataSource

import data.remote.ExerciseApiService


class ExerciseRemoteDataSource(
    private val apiService: ExerciseApiService
) {
   suspend fun getExercise(limit : Int) = apiService.getExerciseList(limit)
}
