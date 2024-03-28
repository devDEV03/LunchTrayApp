package com.example.lunchtrayapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.lunchtrayapp.data.lunchUIstate

@Composable
fun sumScreen(
    onCancelButtonClicked : () -> Unit,
    uiState : lunchUIstate
){
    Column {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = stringResource(id = R.string.order_summary))
            Row {
                Text(
                    text = stringResource(id = uiState.entree.first),
                    modifier = Modifier.align(Alignment.Top)
                )
//                Text(
//                    text = stringResource(id = uiState.entree.second),
//                    modifier = Modifier.align(Alignment.Bottom)
//                )
            }
        }
    }
}