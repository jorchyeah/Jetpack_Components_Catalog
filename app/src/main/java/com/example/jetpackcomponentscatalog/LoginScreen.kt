package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
        Body(Modifier.align(Alignment.Center))
    }
}

@Composable
fun Header(modifier: Modifier) {
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close App", modifier = modifier)
}

@Composable
fun Body(modifier: Modifier) {
    Column(
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_instagram_logo),
            contentDescription = "Instragram word logo",
            modifier = Modifier
                .size(180.dp)
                .align(Alignment.CenterHorizontally)
        )
        Email(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(4.dp))
        Password(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(
            Modifier
                .align(Alignment.End)
                .padding(end = 30.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginButton(
            Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(10.dp))
        LoginDivider()
        Spacer(modifier = Modifier.size(10.dp))
        FacebookLogin()
    }
}

@Composable
fun FacebookLogin() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_fb_logo),
            contentDescription = "Facebook logo",
            modifier = Modifier.size(16.dp)
        )
        Text(text = "Continue as Jorge", modifier = Modifier.padding(horizontal = 6.dp))
    }
}

@Composable
fun LoginDivider() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Divider(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
        Text(text = "OR", modifier = Modifier.padding(horizontal = 6.dp), fontSize = 12.sp)
        Divider(
            modifier = Modifier
                .height(1.dp)
                .weight(1f)
        )
    }
}

@Composable
fun LoginButton(modifier: Modifier) {
    val enabledState = rememberSaveable { mutableStateOf(true) }
    Button(onClick = { enabledState.value = false }, modifier = modifier, enabled = enabledState.value, colors = ButtonDefaults.buttonColors(
        backgroundColor = Color(0xFF4EA8E9),
        disabledBackgroundColor = Color(0xFF78C8F9),
        contentColor = Color.White,
        disabledContentColor = Color.White
    )) {
        Text(text = "Login")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Forgot password?",
        modifier = modifier,
        color = Color.Blue,
        fontWeight = FontWeight.SemiBold,
        fontSize = 12.sp
    )
}

@Composable
fun Email(modifier: Modifier) {
    val textState = rememberSaveable { mutableStateOf("") }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        enabled = true,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = "Phone number, username or email") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = TextStyle(fontSize = 12.sp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun Password(modifier: Modifier) {
    val textState = rememberSaveable { mutableStateOf("") }
    val passwordVisibilityState = rememberSaveable { mutableStateOf(false) }
    TextField(
        value = textState.value,
        onValueChange = { textState.value = it },
        enabled = true,
        modifier = modifier.fillMaxWidth(),
        placeholder = { Text(text = "Password") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        textStyle = TextStyle(fontSize = 12.sp),
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFFB2B2B2),
            backgroundColor = Color(0xFFFAFAFA),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        trailingIcon = {
            val imagen = if (passwordVisibilityState.value) {
                Icons.Filled.VisibilityOff
            } else {
                Icons.Filled.Visibility
            }
            IconButton(onClick = {
                passwordVisibilityState.value = !passwordVisibilityState.value
            }) {
                Icon(imageVector = imagen, contentDescription = "Visibility icon")
            }
        },
        visualTransformation = if (passwordVisibilityState.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    )
}
