package di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ui.home.HomeScreenViewModel
import ui.program.ProgramViewModel
import ui.program_detail.ProgramDetailViewModel

val provideViewModelModule = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModel { ProgramViewModel(get()) }
    viewModel { ProgramDetailViewModel(get()) }
}