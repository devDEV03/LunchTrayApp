package com.example.lunchtrayapp.data

import com.example.lunchtrayapp.R

data class dataSource(
    val entreeList : List<Triple<Int,Int,Int>> = listOf(
        Triple(R.string.entree1head,R.string.entree2head,7)
    )
)
