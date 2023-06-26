package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MyDropdownMenu() {
    val state = rememberSaveable { mutableStateOf("") }
    val expanded = rememberSaveable { mutableStateOf(false) }
    val names = listOf(
        "Eevee",
        "Flareon",
        "Jolteon",
        "Vaporeon",
        "Espeon",
        "Umbreon",
        "Leafeon",
        "Glaceon",
        "Sylveon"
    )

    Column(Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = state.value,
            onValueChange = { state.value = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .clickable { expanded.value = true }
                .fillMaxWidth()
        )
        DropdownMenu(expanded = expanded.value, onDismissRequest = { expanded.value = false }) {
            names.forEach { eeveelution ->
                DropdownMenuItem(onClick = {
                    expanded.value = false
                    state.value = eeveelution
                }) {
                    Text(text = eeveelution)
                }
            }
        }
    }
}

