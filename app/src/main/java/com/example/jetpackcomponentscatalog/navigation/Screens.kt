package com.example.jetpackcomponentscatalog.navigation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackcomponentscatalog.compose.*

@Composable
fun MainScreen(navController: NavHostController) {
    ScaffoldTemplate("Jetpack Components Catalog", navController) {
        NavButtons(navController = navController)
    }
}

@Composable
fun AppBars(navController: NavHostController) {
    ScaffoldTemplate("AppB Bars", navController) {
        AppBarsSetup()
    }
}

@Composable
fun Buttons(navController: NavHostController) {
    ScaffoldTemplate("Buttons", navController) {
        ButtonsSetup()
    }
}

@Composable
fun Card(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Card", navController = navController) {
        MyCard()
    }
}

@Composable
fun Dialogs(navController: NavHostController) {
    val show = remember { mutableStateOf(true) }

    ScaffoldTemplate(topBarTitle = "Dialogs", navController = navController) {
        MyDialogSetup(show = show)
    }
}

@Composable
fun DropdownMenu(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Dropdown Menu", navController = navController) {
        MyDropdownMenu()
    }
}

@Composable
fun Image(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Image", navController = navController) {
        MyImage()
    }
}

@Composable
fun ProgressBar(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Progress Bar", navController = navController) {
        MyProgressBar()
    }
}

@Composable
fun Scaffold(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Scaffold", navController = navController) {
        MyScaffold()
    }
}

@Composable
fun Slider(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Slider", navController = navController) {
        MySlider()
    }
}

@Composable
fun Texts(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Texts", navController = navController) {
        TextsSetup()
    }
}

@Composable
fun Toggles(navController: NavHostController) {
    ScaffoldTemplate(topBarTitle = "Toggles", navController = navController) {
        TogglesSetup()
    }
}

@Composable
fun ScaffoldTemplate(
    topBarTitle: String,
    navController: NavHostController,
    content: @Composable () -> Unit
) {
    Scaffold(topBar = { TopAppBarTemplate(topBarTitle, navController) }) {
        content()
    }
}

@Composable
fun TopAppBarTemplate(topBarTitle: String, navController: NavHostController) {
    TopAppBar(
        title = { Text(text = topBarTitle) },
        backgroundColor = Color.Blue,
        contentColor = Color.White,
        navigationIcon = { BackArrowButton(navController) }
    )
}

@Composable
fun BackArrowButton(navController: NavHostController) {
    IconButton(
        onClick = { navController.navigate("Main Screen") },
        content = {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    )
}


@Composable
fun NavButtons(navController: NavHostController) {
    val components = getComponents()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(32.dp))

        components.forEach {
            Button(
                onClick = { navController.navigate(it) },
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.Blue,
                    contentColor = Color.White
                )
            )
            {
                Text(text = it, fontSize = 18.sp)
            }
        }
    }
}

@Composable
fun AppBarsSetup() {
    Column(
        modifier = Modifier.size(300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyAppBars()
    }
}

@Composable
fun ButtonsSetup() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MyButton()
        MyLikeButton()
        MyExtendedLikeButton()
    }
}

@Composable
fun TextsSetup() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyText()
        Spacer(modifier = Modifier.size(24.dp))
        MyTextField()
        Spacer(modifier = Modifier.size(24.dp))
        MyTextFieldOutlined()
    }
}

@Composable
fun TogglesSetup() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MyRadioButtons()
        Spacer(modifier = Modifier.size(24.dp))
        MyTriStateCheckBox()
        Spacer(modifier = Modifier.size(24.dp))
        MyCheckBox()
        Spacer(modifier = Modifier.size(24.dp))
        MySwitch()
    }
}