package di

import domain.interactor.HomeInteractor
import domain.interactor.ProgramInteractor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val provideInteractorModule = module {
    single<HomeInteractor> { HomeInteractor(get()) }
    single<ProgramInteractor> { ProgramInteractor(get()) }
}