package com.example.jetpackcomponentscatalog.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyScaffold() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { MyTopAppBar { coroutineScope.launch { scaffoldState.drawerState.open() } } },
        bottomBar = { MyBottomAppBar { coroutineScope.launch { scaffoldState.snackbarHostState.showSnackbar("Click!") } } },
        floatingActionButton = { MyExtendedLikeButton() },
        drawerGesturesEnabled = true,
        drawerContent = { MyDrawer { coroutineScope.launch { scaffoldState.drawerState.close() } } },
    ) {

    }
}

@Composable
fun MyDrawer(closeDrawer: () -> Unit) {
    Column {
        for (i in 1..5) {
            Text(
                text = "item $i",
                modifier = Modifier
                    .padding(top = 8.dp, start = 16.dp)
                    .clickable { closeDrawer() }
            )
        }
    }
}