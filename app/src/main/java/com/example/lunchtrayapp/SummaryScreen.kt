package com.example.lunchtrayapp

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
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
    uiState : lunchUIstate,
    modifier : Modifier = Modifier,
    onSendButtonClicked : (String,String) -> Unit
){
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = stringResource(id = R.string.order_summary))
//            Row(
//                modifier = Modifier.fillMaxWidth()
//            ){
//                Text(
//                    text = stringResource(id = uiState.entree.first),
//
//                )
////                Spacer(modifier = Modifier.width(220.dp))
//                Text(
//                    text = Integer.toString(uiState.entree.second) ,
//                    textAlign = TextAlign.Right
//
//                )
//            }
            itemSummary(pair = uiState.entree, modifier = Modifier.fillMaxWidth())
            itemSummary(pair = uiState.side_dish, modifier = Modifier.fillMaxWidth())
            itemSummary(pair = uiState.accompaniment, modifier = Modifier.fillMaxWidth())
//            Row{
//                Text(
//                    text = stringResource(id = uiState.side_dish.first),
//                    textAlign = TextAlign.Left
//                )
////                Spacer(modifier = Modifier.width(200.dp))
//                Text(
//                    text = Integer.toString(uiState.side_dish.second),
//                    textAlign = TextAlign.Right
//                )
//            }
//            Row {
//                Text(
//                    text = stringResource(id = uiState.accompaniment.first),
//                    textAlign = TextAlign.Start
//                )
////                Spacer(modifier = Modifier.width(200.dp))
//                Text(
//                    text = Integer.toString(uiState.accompaniment.second),
//                    textAlign = TextAlign.End
//                )
//            }
            Divider(modifier = Modifier.padding(end = 5.dp), thickness = 3.dp)

            Text(text = stringResource(id = R.string.subtotal),
                textAlign = TextAlign.Center)
            Text(text = stringResource(id = R.string.tax),
                textAlign = TextAlign.End)
            Text(text = stringResource(id = R.string.total),
                textAlign = TextAlign.End)
            
            Row {
                Button(onClick = { onCancelButtonClicked }) {
                    Text(text = stringResource(id = R.string.Cancel))
                }
                OutlinedButton(onClick = {onSendButtonClicked("Dev","Singhal") /*TODO*/ }) {
                    Text(text = "Share")
                }
            }

        }
    }


@Composable
fun itemSummary(
    modifier: Modifier = Modifier,
    pair : Pair<Int,Int>
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
    ) {
        Text(text = stringResource(id = pair.first))
        Text(text = pair.second.toString())
    }

}

