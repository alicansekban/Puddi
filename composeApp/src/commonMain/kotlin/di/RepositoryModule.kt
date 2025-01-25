package di

import data.repository.ExerciseRepository
import data.repository.ExerciseRepositoryImpl
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<ExerciseRepository> { ExerciseRepositoryImpl(get(),get()) }

}