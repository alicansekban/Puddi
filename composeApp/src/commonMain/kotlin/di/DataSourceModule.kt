package di

import data.dataSource.ExerciseLocalDataSource
import data.dataSource.ExerciseRemoteDataSource
import org.koin.dsl.module

val provideDataSourceModule = module {
    single<ExerciseRemoteDataSource> { ExerciseRemoteDataSource(get()) }
    single<ExerciseLocalDataSource> { ExerciseLocalDataSource(get()) }


}