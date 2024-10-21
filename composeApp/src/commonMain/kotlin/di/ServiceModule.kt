package di

import data.remote.ExerciseApiService
import org.koin.dsl.module

val serviceModule = module {
    single<ExerciseApiService> { ExerciseApiService(get()) }

}