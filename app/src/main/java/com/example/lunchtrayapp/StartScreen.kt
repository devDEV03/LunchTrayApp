package com.example.lunchtrayapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@SuppressLint("ComposableNaming")
@Composable
fun startScreen(
    onNextButtonClicked : () -> Unit
){
   Column(
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally,
       modifier = Modifier.fillMaxSize()
   ) {

        Button(
            onClick = onNextButtonClicked) {
            Text(text = "START ORDER")
        }
    }
}