package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun MyDialogSetup(show: MutableState<Boolean>) {
    Column(
        Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { show.value = true }) {
            Text(text = "Click here to see the dialog")
        }

        if (show.value) {
            MyAlertDialog { show.value = false }
        }
    }
}

@Composable
fun MyAlertDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Alert Dialog") },
        text = { Text("Lorem ipsum") },
        confirmButton = { Button(onClick = { onDismiss() }, content = { Text("Ok") }) },
        dismissButton = { Button(onClick = { onDismiss() }, content = { Text("Deny") }) }
    )
}


@Composable
fun MyCustomDialog() {
    Dialog(onDismissRequest = { }) {

    }
}

