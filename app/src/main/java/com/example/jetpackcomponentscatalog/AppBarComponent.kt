package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyAppBars() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Column(verticalArrangement = Arrangement.Top) {
        MyTopAppBar { coroutineScope.launch { scaffoldState.drawerState.open() } }
    }
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Bottom) {
        MyBottomAppBar { coroutineScope.launch { scaffoldState.snackbarHostState.showSnackbar("Click!") } }
    }
}

@Composable
fun MyTopAppBar(openDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Top App Bar") },
        backgroundColor = Color.Yellow,
        contentColor = Color.Black,
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.padding(8.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = { openDrawer() }) {
                Icon(
                    imageVector = Icons.Filled.Menu,
                    contentDescription = "Back",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    )
}

@Composable
fun MyBottomAppBar(showSnackBar: () -> Unit) {
    BottomAppBar(
        backgroundColor = Color.Yellow,
        contentColor = Color.Black,
    ) {
        BottomNavigationItem(
            selected = true,
            onClick = { showSnackBar() },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = "Home",
                )
            }
        )
    }
}