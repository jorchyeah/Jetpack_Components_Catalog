package com.example.jetpackcomponentscatalog

import android.util.Patterns
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

class LoginScreenViewModel {
    fun checkEmail(emailState: MutableState<String>): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(emailState.value).matches()

    fun checkPassword(passwordState: MutableState<String>): Boolean = passwordState.value.length > 6

    fun enableLogin(
        isEmailApproved: MutableState<Boolean>,
        isPasswordApproved: MutableState<Boolean>
    ): Boolean = isEmailApproved.value && isPasswordApproved.value

    fun setPasswordVisibility(passwordVisibility: MutableState<Boolean>): VisualTransformation {
        return if (passwordVisibility.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    }

    fun setIconVisibility(passwordVisibility: MutableState<Boolean>): ImageVector {
        return if (passwordVisibility.value) {
            Icons.Filled.Visibility
        } else {
            Icons.Filled.Visibility
        }
    }
}