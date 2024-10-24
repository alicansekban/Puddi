package di

import ExerciseRepository
import org.koin.dsl.module

val provideRepositoryModule = module {
    single<ExerciseRepository> { ExerciseRepository(get(),get()) }

}