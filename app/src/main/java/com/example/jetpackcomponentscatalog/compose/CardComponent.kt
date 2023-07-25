package com.example.jetpackcomponentscatalog.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyCard() {
    Card(
        Modifier.padding(32.dp), elevation = 12.dp
    ) {
        Text(
            text = "Hola")
    }
}