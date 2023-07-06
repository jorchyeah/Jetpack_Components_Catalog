package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAppBars() {
    Column(verticalArrangement = Arrangement.Top) {
        MyTopAppBar()
    }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        MyBottomAppBar(Modifier.align(CenterHorizontally))
    }
}

@Composable
fun MyTopAppBar() {
        TopAppBar(
            backgroundColor = Color.Yellow,
            contentColor = Color.Black
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier.padding(8.dp)
            )
    }
}

@Composable
fun MyBottomAppBar(modifier: Modifier) {
        BottomAppBar(
            backgroundColor = Color.Yellow,
            contentColor = Color.Black,
        ) {
            Icon(
                imageVector = Icons.Filled.Home,
                contentDescription = "Back",
                modifier = modifier.weight(1F)
            )
        }
}