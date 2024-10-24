package di

import domain.interactor.HomeInteractor
import org.koin.dsl.module

val provideInteractorModule = module {
    single<HomeInteractor> { HomeInteractor(get()) }
}