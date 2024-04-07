package com.example.lunchtrayapp.data

data class lunchUIstate(
    val entree : Pair<Int,Int> = Pair(0,0),
    val side_dish : Pair<Int,Int> = Pair(0,0),
    val accompaniment : Pair<Int,Int> = Pair(0,0),
    val total_bill : Double = 0.00,
    val tax : Double = 0.00,
    val subtotal : Int = 0
)
