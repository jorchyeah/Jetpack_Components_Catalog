package com.example.jetpackcomponentscatalog

import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color

class TwitterFeedViewModel {

    fun iconChooser(icon: Triple<String, MutableState<Boolean>, MutableState<Int>>) {
        when {
            (icon.first == "chatIcon" && icon.second.value) -> icon.third.value =
                R.drawable.ic_chat_filled
            (icon.first == "chatIcon" && !icon.second.value) -> icon.third.value =
                R.drawable.ic_chat
            (icon.first == "likeIcon" && icon.second.value) -> icon.third.value =
                R.drawable.ic_like_filled
            (icon.first == "likeIcon" && !icon.second.value) -> icon.third.value =
                R.drawable.ic_like
            else -> icon.third.value = R.drawable.ic_rt
        }
    }

    fun colorChooser(icon: Triple<String, MutableState<Boolean>, MutableState<Int>>): Color {
        return when {
            ((icon.first == "chatIcon" || icon.first == "likeIcon") && icon.second.value) -> Color.Red
            icon.first == "retweetIcon" && icon.second.value -> Color.Green
            else -> Color.Black
        }
    }

    fun clickCounter(
        clicks: Int,
        iconClicked: Triple<String, MutableState<Boolean>, MutableState<Int>>
    ): Int {
        return if (iconClicked.second.value) {
            clicks.plus(1)
        } else {
            clicks
        }
    }
}