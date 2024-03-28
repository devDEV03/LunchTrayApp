package com.example.lunchtrayapp

import androidx.lifecycle.ViewModel
import com.example.lunchtrayapp.data.lunchUIstate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LunchViewModel : ViewModel() {
    private val _uistate = MutableStateFlow(lunchUIstate())
    var uistate : StateFlow<lunchUIstate> = _uistate.asStateFlow()

    fun setEntree(t1 : Triple<Int,Int,Int>){
        _uistate.update {
            currentState -> currentState.copy(
                entree = Pair(t1.first,t1.third)
            )
        }
    }
}