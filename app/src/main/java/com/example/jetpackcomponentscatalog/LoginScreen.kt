package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    //val activity = LocalContext.current as Activity

    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Header(
            Modifier
                .align(Alignment.TopEnd)
            //.clickable { activity.finish() }
        )
    }
}

@Composable
fun Header(modifier: Modifier) {
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close App", modifier = modifier)
}
