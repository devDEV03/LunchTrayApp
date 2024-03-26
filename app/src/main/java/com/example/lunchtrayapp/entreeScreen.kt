package com.example.lunchtrayapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun EntreeScreen(
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked : () -> Unit,
    selectedEntree : (Triple<String,String,Int>) -> Unit,
    entreeOptions : List<Triple<String,String,Int>>
){

    var selectedItem by rememberSaveable {
        mutableStateOf("")
    }
    Column(

    ) {
        entreeOptions.forEach{
            item ->
            Row {
                RadioButton(selected = item.first == selectedItem, onClick = {selectedEntree(item)})
                Column {
                    Text(text = item.first, style = MaterialTheme.typography.displayMedium)
                    Text(text = item.second, style = MaterialTheme.typography.bodyMedium)
                    Text(text = stringResource(id = R.string.price_tag,item.third), style = MaterialTheme.typography.displaySmall)
                }
            }
            Divider(thickness = 3.dp)
        }

    }


}