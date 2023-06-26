package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyTextFieldOutlined() {
    val editTextState = rememberSaveable { mutableStateOf("") }

    Column() {
        OutlinedTextField(
            value = editTextState.value,
            onValueChange = { editTextState.value = it },
            modifier = Modifier.padding(24.dp),
            label = { Text(text = "Usuario") }
        )
    }
}

@Composable
fun MyTextField() {
    val myEditText = rememberSaveable { mutableStateOf("") }
    TextField(
        value = myEditText.value,
        onValueChange = { myEditText.value = it },
        label = { "Ingresa cualquier texto aquí" })
}

@Composable
fun MyText() {
    Column(Modifier.fillMaxSize()) {
        Text("Esto es un ejemplo")
        Text("Esto es un ejemplo", color = Color.Blue)
        Text("Esto es un ejemplo", fontWeight = FontWeight.ExtraBold)
        Text("Esto es un ejemplo", fontWeight = FontWeight.Light)
        Text("Esto es un ejemplo", style = TextStyle(fontFamily = FontFamily.Cursive))
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text("Esto es un ejemplo", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text(
            "Esto es un ejemplo",
            style = TextStyle(
                fontFamily = FontFamily.Cursive,
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough,
                        TextDecoration.Underline
                    )
                )
            )
        )
        Text("Esto es un ejemplo", fontSize = 30.sp)
    }
}