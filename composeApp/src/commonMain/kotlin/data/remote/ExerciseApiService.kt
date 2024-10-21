package data.remote

import data.response.ExerciseResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.appendPathSegments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import utils.Constants
import utils.ResultWrapper
import utils.safeApiCall

class ExerciseApiService(
    private val client: HttpClient
) {

    suspend fun getExerciseList(limit: Int): ResultWrapper<ExerciseResponse> =
        safeApiCall(Dispatchers.IO) {
            client.get {
                url {
                    appendPathSegments("exercise", )
                    parameters.append("limit", limit.toString())
                }
            }.body()
        }

}