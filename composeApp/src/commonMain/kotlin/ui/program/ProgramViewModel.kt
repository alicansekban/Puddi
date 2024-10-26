package ui.program

import androidx.lifecycle.ViewModel
import domain.interactor.ProgramInteractor

class ProgramViewModel(
    private val interactor: ProgramInteractor
) : ViewModel(){
}