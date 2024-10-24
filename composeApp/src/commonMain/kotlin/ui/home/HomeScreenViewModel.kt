package ui.home

import androidx.lifecycle.ViewModel
import domain.interactor.HomeInteractor

class HomeScreenViewModel(
    private val interactor: HomeInteractor
) : ViewModel(){
}