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
                sumScreen(
                    onCancelButtonClicked = { cancelAndReset(navCon,lunchModel) },
                    uiState = uistate
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
