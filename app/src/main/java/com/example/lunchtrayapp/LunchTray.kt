package com.example.lunchtrayapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

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
    Scaffold(
        topBar = { CenterAlignedTopAppBar(title = { /*TODO*/ }) }
    ) {
        innerPadding ->

        val uistate by lunchModel.uistate.collectAsState()
        NavHost(
            navController = navCon,
            startDestination = Screens.Start.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = Screens.Start.name){
                
            }
            composable(route = Screens.Entree_Menu.name){

            }
            composable(route = Screens.Side_Menu.name){

            }

            composable(route = Screens.Accompaniment_Menu.name){

            }

            composable(route = Screens.Checkout.name){

            }
        }
        

    }

}