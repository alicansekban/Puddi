package di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ui.home.HomeScreenViewModel
import ui.program.ProgramViewModel

val provideViewModelModule = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModel { ProgramViewModel(get()) }
}