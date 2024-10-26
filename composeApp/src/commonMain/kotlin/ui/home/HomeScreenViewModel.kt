package ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.BaseUIModel
import domain.interactor.HomeInteractor
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class HomeScreenViewModel(
    private val interactor: HomeInteractor
) : ViewModel(){

    private val _uiState = MutableStateFlow<BaseUIModel<List<String>>>(BaseUIModel.Loading)
    val uiState = _uiState.stateIn(viewModelScope, SharingStarted.Eagerly, BaseUIModel.Loading)

}