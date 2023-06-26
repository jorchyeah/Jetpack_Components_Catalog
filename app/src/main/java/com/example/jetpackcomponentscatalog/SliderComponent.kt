package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Slider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MySlider() {
    val state = rememberSaveable { mutableStateOf(0f) }
    Column(Modifier.padding(20.dp)) {
        Slider(value = state.value, onValueChange = { state.value = it }, steps = 9)
        Text(text = state.value.toString(), modifier = Modifier.align(CenterHorizontally))
    }
}