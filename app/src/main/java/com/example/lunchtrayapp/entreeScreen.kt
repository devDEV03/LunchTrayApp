package com.example.lunchtrayapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun OptionsScreen(
    onNextButtonClicked : () -> Unit,
    onCancelButtonClicked : () -> Unit,
    selectedOption : (Triple<Int,Int,Int>) -> Unit,
    itemList : List<Triple<Int,Int,Int>>
){

    var selectedItem by rememberSaveable {
        mutableStateOf(0)
    }
    Column(

    ) {
        itemList.forEach{
            item ->
            Row(
                modifier = Modifier.clickable {
                    selectedItem = item.first
                    selectedOption(item) }
                    .fillMaxWidth()
            ) {
                RadioButton(
                    selected = item.first == selectedItem,
                    onClick = {selectedOption(item)},
                    modifier = Modifier.padding(top = 30.dp)
                )
                Column(
                    modifier = Modifier.padding(
                        start = dimensionResource(id = R.dimen.small_dp),
                        bottom = dimensionResource(id = R.dimen.small_dp)
                    ),
                    verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_dp))

                ) {
                    Text(text = stringResource(id = item.first), style = MaterialTheme.typography.titleLarge)
                    Text(text = stringResource(id = item.second), style = MaterialTheme.typography.bodyLarge)
                    Text(text = stringResource(id = R.string.price_tag,item.third), style = MaterialTheme.typography.bodyLarge)
                }
            }
            Divider(thickness = 3.dp)
        }
        Spacer(modifier = Modifier.height(40.dp))
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
                    .clip(MaterialTheme.shapes.small)
            ) {
                Text(text = stringResource(id = R.string.Cancel))
            }
            Spacer(modifier = Modifier.width(4.dp))
            Button(onClick = { onNextButtonClicked() },
                modifier = Modifier
                    .size(175.dp, 60.dp)
                    .padding(5.dp),
                enabled = selectedItem != 0
            ) {
                Text(text = stringResource(id = R.string.Next))
            }
        }

    }


}