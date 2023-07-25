package com.example.jetpackcomponentscatalog.model

sealed class Routes(val route: String) {
    object MainScreen : Routes("Main Screen")
    object AppBarsScreen : Routes("App Bars")
    object ButtonsScreen : Routes("Buttons")
    object CardScreen : Routes("Card")
    object DialogScreen : Routes("Dialog")
    object DropdownMenuScreen : Routes("Dropdown Menu")
    object ImageScreen : Routes("Image")
    object ProgressBarScreen : Routes("Progress Bar")
    object ScaffoldScreen : Routes("Scaffold")
    object SliderScreen : Routes("Slider")
    object TextsScreen : Routes("Text")
    object TogglesScreen : Routes("Toggles")
}
