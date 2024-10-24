package di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ui.home.HomeScreenViewModel

val provideViewModelModule = module {
    viewModel { HomeScreenViewModel(get()) }
}