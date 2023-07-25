package com.example.jetpackcomponentscatalog.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomponentscatalog.model.Routes

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.MainScreen.route) {
        composable(Routes.MainScreen.route) { MainScreen(navController) }
        composable(Routes.AppBarsScreen.route) { AppBars(navController) }
        composable(Routes.ButtonsScreen.route) { Buttons(navController) }
        composable(Routes.CardScreen.route) { Card(navController) }
        composable(Routes.DialogScreen.route) { Dialogs(navController) }
        composable(Routes.DropdownMenuScreen.route) { DropdownMenu(navController)}
        composable(Routes.ImageScreen.route) { Image(navController) }
        composable(Routes.ProgressBarScreen.route) { ProgressBar(navController) }
        composable(Routes.ScaffoldScreen.route) { Scaffold(navController)}
        composable(Routes.SliderScreen.route) { Slider(navController) }
        composable(Routes.TextsScreen.route) { Texts(navController) }
        composable(Routes.TogglesScreen.route) { Toggles(navController) }
    }

}

@Composable
fun getComponents(): List<String> {
    return listOf(
        "App Bars",
        "Buttons",
        "Card",
        "Dialog",
        "Dropdown Menu",
        "Image",
        "Progress Bar",
        "Scaffold",
        "Slider",
        "Text",
        "Toggles",
    )
}