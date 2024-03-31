package com.example.lunchtrayapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.lunchtrayapp.data.lunchUIstate

@Composable
fun sumScreen(
    onCancelButtonClicked : () -> Unit,
    uiState : lunchUIstate
){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(text = stringResource(id = R.string.order_summary))
            Row{
                Text(
                    text = stringResource(id = uiState.entree.first),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(220.dp))
                Text(
                    text = Integer.toString(uiState.entree.second) ,
                    textAlign = TextAlign.End

                )
            }
            Row {
                Text(
                    text = stringResource(id = uiState.side_dish.first),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(240.dp))
                Text(
                    text = Integer.toString(uiState.side_dish.second),
                    textAlign = TextAlign.End
                )
            }
            Row {
                Text(
                    text = stringResource(id = uiState.accompaniment.first),
                    textAlign = TextAlign.Start
                )
                Spacer(modifier = Modifier.width(240.dp))
                Text(
                    text = Integer.toString(uiState.accompaniment.second),
                    textAlign = TextAlign.End
                )
            }
            Divider(modifier = Modifier.padding(end = 5.dp), thickness = 3.dp)

            Text(text = stringResource(id = R.string.subtotal),
                textAlign = TextAlign.End)
            Text(text = stringResource(id = R.string.tax),
                textAlign = TextAlign.End)
            Text(text = stringResource(id = R.string.total),
                textAlign = TextAlign.End)


        }
    }
}