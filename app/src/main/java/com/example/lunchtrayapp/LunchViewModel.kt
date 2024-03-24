package com.example.lunchtrayapp

import androidx.lifecycle.ViewModel
import com.example.lunchtrayapp.data.lunchUIstate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class LunchViewModel : ViewModel() {
    private val _uistate = MutableStateFlow(lunchUIstate())
    var uistate : StateFlow<lunchUIstate> = _uistate.asStateFlow()

}