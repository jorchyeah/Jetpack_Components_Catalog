package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_foreground),
        contentDescription = "Ejemplo",
        colorFilter = ColorFilter.tint(Color.Blue)
    )
}