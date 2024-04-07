package com.example.lunchtrayapp

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.lunchtrayapp.data.accList
import com.example.lunchtrayapp.data.entreeList
import com.example.lunchtrayapp.data.lunchUIstate
import com.example.lunchtrayapp.data.sideList

enum class Screens{
    Start,
    Entree_Menu,
    Side_Menu,
    Accompaniment_Menu,
    Checkout
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navCon : NavHostController = rememberNavController(),
    lunchModel : LunchViewModel = viewModel()
)
{
    val backStackEntry by navCon.currentBackStackEntryAsState()
    val currentScreen = Screens.valueOf(
        backStackEntry?.destination?.route?:Screens.Start.name
    )
    Scaffold(
        topBar = {
            TopAppBar(
                currentScreen = currentScreen,
                canNavigateBack = navCon.previousBackStackEntry != null,
                navigateUp = { navCon.navigateUp() },
                modifier = Modifier
            )
        },
        bottomBar = {
            bottomBar()
        }
    ) {
        innerPadding ->

        val uistate by lunchModel.uistate.collectAsState()
        NavHost(
            navController = navCon,
            startDestination = Screens.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Screens.Start.name){
                startScreen (
                    onNextButtonClicked = {navCon.navigate(Screens.Entree_Menu.name)}
                )
            }
            composable(route = Screens.Entree_Menu.name){
                OptionsScreen(
                    onNextButtonClicked = { navCon.navigate(Screens.Side_Menu.name) },
                    onCancelButtonClicked = { cancelAndReset(navCon,lunchModel) },
                    selectedOption = { lunchModel.setEntree(it) },
                    itemList = entreeList
                )
            }
            composable(route = Screens.Side_Menu.name){
                OptionsScreen(
                    onNextButtonClicked = { navCon.navigate(Screens.Accompaniment_Menu.name) },
                    onCancelButtonClicked = { cancelAndReset(navCon,lunchModel) },
                    selectedOption = { lunchModel.setSides(it) },
                    itemList = sideList
                )
            }

            composable(route = Screens.Accompaniment_Menu.name){
                OptionsScreen(
                    onNextButtonClicked = { navCon.navigate(Screens.Checkout.name) },
                    onCancelButtonClicked = { cancelAndReset(navCon,lunchModel) },
                    selectedOption = { lunchModel.setAcc(it) },
                    itemList = accList
                )
            }

            composable(route = Screens.Checkout.name){
                val context = LocalContext.current
                sumScreen(
                    onCancelButtonClicked = { cancelAndReset(navCon,lunchModel) },
                    uiState = uistate,
                    onSendButtonClicked = {
                        summary : String,order : String ->
                        shareOrder(context,summary,order)
                    }
                )
            }
        }
        

    }

}

private fun cancelAndReset(
    navCon : NavHostController,
    lunchView : LunchViewModel
){
//    lunchView.resetOrder()
    navCon.popBackStack(Screens.Start.name,false)

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    currentScreen : Screens,
    canNavigateBack : Boolean,
    navigateUp : () -> Unit = {},
    modifier : Modifier
){
    CenterAlignedTopAppBar(title = {
        Text(text = currentScreen.name)
    },
        navigationIcon = {
            if(canNavigateBack){
                IconButton(onClick = {navigateUp}) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }
            }
        }
    )
}

@Composable
fun bottomBar(
){
    NavigationBar(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row (
            modifier  = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = null)
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.KeyboardArrowUp, contentDescription = null)
            }

            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null)
            }

        }

    }
}

private fun shareOrder(
    context: Context,
    summary : String,
    order : String
){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, order)
        putExtra(Intent.EXTRA_TEXT, summary)
    }
    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.tax)
        )
    )

}

