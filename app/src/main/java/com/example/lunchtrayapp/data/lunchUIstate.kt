package com.example.lunchtrayapp.data

data class lunchUIstate(
    val entree : Pair<String,Int> = Pair("",0),
    val side_dish : Pair<String,Int> = Pair("",0),
    val accompaniment : Pair<String,Int> = Pair("",0),
)
