package com.example.jetpackcomponentscatalog

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val loginScreenViewModel = LoginScreenViewModel()

@Composable
fun LoginScreen() {
    val activity = LocalContext.current as Activity

    Box(
        Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Header(
            Modifier
                .align(Alignment.TopEnd)
                .clickable { activity.finish() }
        )
        Body(Modifier.align(Alignment.Center))
        Footer(Modifier.align(Alignment.BottomCenter))
    }
}

@Composable
fun Header(modifier: Modifier) {
    Icon(imageVector = Icons.Default.Close, contentDescription = "Close App", modifier = modifier)
}

@Composable
fun Body(modifier: Modifier) {
    val isEmailApproved = rememberSaveable { mutableStateOf(false) }
    val isPasswordApproved = rememberSaveable { mutableStateOf(false) }
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
        Email(isEmailApproved, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(4.dp))
        Password(isPasswordApproved, Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(8.dp))
        ForgotPassword(
            Modifier
                .align(Alignment.End)
                .padding(end = 30.dp)
        )
        Spacer(modifier = Modifier.size(20.dp))
        LoginButton(
            isEmailApproved,
            isPasswordApproved,
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
fun Footer(modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Divider(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.size(24.dp))
        SignUp()
        Spacer(modifier = Modifier.size(12.dp))
    }
}

@Composable
fun SignUp() {
    Row() {
        Text(text = "Don't have an account?", fontSize = 12.sp)
        Text(
            text = "Sign up",
            color = Color.Blue,
            modifier = Modifier.padding(start = 6.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = ".", fontSize = 12.sp)
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
fun LoginButton(
    isEmailApproved: MutableState<Boolean>,
    isPasswordApproved: MutableState<Boolean>,
    modifier: Modifier
) {
    rememberSaveable { mutableStateOf(false) }
    Button(
        onClick = {},
        modifier = modifier,
        enabled = loginScreenViewModel.enableLogin(isEmailApproved, isPasswordApproved),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF4EA8E9),
            disabledBackgroundColor = Color(0xFF78C8F9),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ) {
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
fun Email(isEmailApproved: MutableState<Boolean>, modifier: Modifier) {
    val email = rememberSaveable { mutableStateOf("") }
    TextField(
        value = email.value,
        onValueChange = {
            email.value = it
            isEmailApproved.value = loginScreenViewModel.checkEmail(email)
        },
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
fun Password(isPasswordApproved: MutableState<Boolean>, modifier: Modifier) {
    val password = rememberSaveable { mutableStateOf("") }
    val passwordVisibility = rememberSaveable { mutableStateOf(false) }
    TextField(
        value = password.value,
        onValueChange = {
            password.value = it
            isPasswordApproved.value = loginScreenViewModel.checkPassword(password)
        },
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
            val imagen = loginScreenViewModel.setIconVisibility(passwordVisibility)
            IconButton(onClick = { passwordVisibility.value = !passwordVisibility.value }) {
                Icon(imageVector = imagen, contentDescription = "Visibility icon")
            }
        },
        visualTransformation = loginScreenViewModel.setPasswordVisibility(passwordVisibility)
    )
}
