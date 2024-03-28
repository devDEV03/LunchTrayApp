package com.example.lunchtrayapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun EntreeScreen(
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked : () -> Unit,
    selectedEntree : (Triple<Int,Int,Int>) -> Unit,
    entreeOptions : List<Triple<Int,Int,Int>>
){

    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    Column(

    ) {
        entreeOptions.forEach{
            item ->
            Row {
                RadioButton(
                    selected = item.first == selectedItem,
                    onClick = {selectedEntree(item)},
                    modifier = Modifier.padding(top = 30.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.small_dp),
                        bottom = dimensionResource(id = R.dimen.small_dp)
                    ),
                    verticalArrangement = Arrangement.spacedBy(10.dp)

                ) {
                    Text(text = stringResource(id = item.first), style = MaterialTheme.typography.titleLarge)
                    Text(text = stringResource(id = item.second), style = MaterialTheme.typography.bodyLarge)
                    Text(text = stringResource(id = R.string.price_tag,item.third), style = MaterialTheme.typography.bodyLarge)
                }
            }
            Divider(thickness = 3.dp)
        }
        Spacer(modifier = Modifier.height(150.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
        ){
            OutlinedButton(onClick = { onCancelButtonClicked() },
                modifier = Modifier
                    .size(175.dp, 60.dp)
                    .padding(5.dp)
            ) {
                Text(text = stringResource(id = R.string.Cancel))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = { onNextButtonClicked() },
                modifier = Modifier
                    .size(175.dp, 60.dp)
                    .padding(5.dp)
            ) {
                Text(text = stringResource(id = R.string.Next))
            }
        }

    }


}