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

    fun setSides(t1 : Triple<Int,Int,Int>){
        _uistate.update {
                currentState -> currentState.copy(
            side_dish = Pair(t1.first,t1.third)
        )
        }
    }
    fun setAcc(t1 : Triple<Int,Int,Int>){
        _uistate.update {
                currentState -> currentState.copy(
            accompaniment = Pair(t1.first,t1.third)
        )
        }
    }

    fun calculateBill(){
        val subtotal1 = _uistate.value.entree.second + _uistate.value.side_dish.second + _uistate.value.accompaniment.second
        val tax1 = (_uistate.value.entree.second + _uistate.value.side_dish.second + _uistate.value.accompaniment.second)*0.05
        val total1 =  subtotal1 + tax1

        _uistate.update {
            currentState -> currentState.copy(
                subtotal = subtotal1,
                tax = tax1,
                total_bill = total1
            )
        }
    }

}