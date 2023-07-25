package com.example.jetpackcomponentscatalog.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState

@Composable
fun MyRadioButtons() {
    val state = rememberSaveable { mutableStateOf("Default") }
    Column(Modifier.fillMaxWidth()) {
        Row() {
            Text(state.value)
        }
        Row() {
            RadioButton(selected = state.value == "Uno", onClick = {
                state.value = "Uno"
            })
            Text(text = "Uno")
        }
        Row() {
            RadioButton(selected = state.value == "Dos", onClick = {
                state.value = "Dos"
            })
            Text(text = "Dos")
        }
        Row() {
            RadioButton(selected = state.value == "Tres", onClick = {
                state.value = "Tres"
            })
            Text(text = "Tres")
        }
        Row() {
            RadioButton(selected = state.value == "Cuatro", onClick = {
                state.value = "Cuatro"
            })
            Text(text = "Cuatro")
        }
    }
}

@Composable
fun MyTriStateCheckBox() {
    val state = rememberSaveable { mutableStateOf(ToggleableState(false)) }
    TriStateCheckbox(state = state.value, onClick = {
        state.value = when (state.value) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    })
}

@Composable
fun MyCheckBox() {
    val state = rememberSaveable { mutableStateOf(false) }
    Checkbox(checked = state.value, onCheckedChange = { state.value = !state.value })
}

@Composable
fun MySwitch() {
    val state = rememberSaveable { mutableStateOf(true) }
    Switch(checked = state.value, onCheckedChange = { state.value = !state.value })
}