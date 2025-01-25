package di

import data.dataSource.ExerciseLocalDataSource
import data.dataSource.ExerciseLocalDataSourceImp
import data.dataSource.ExerciseRemoteDataSource
import data.dataSource.ExerciseRemoteDataSourceImpl
import org.koin.dsl.module

val provideDataSourceModule = module {
    single<ExerciseRemoteDataSource> { ExerciseRemoteDataSourceImpl(get()) }
    single<ExerciseLocalDataSource> { ExerciseLocalDataSourceImp(get()) }


}