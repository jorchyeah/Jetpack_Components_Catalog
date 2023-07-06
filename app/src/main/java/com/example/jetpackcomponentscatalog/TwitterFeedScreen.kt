package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TwitterFeedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Header()
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Avatar()
        UserTitle()
        MoreOptionsButton()
    }
}



@Composable
fun UserTitle() {
    Row(
        modifier = Modifier.padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Nickname()
        UserName()
    }
}

@Composable
fun MoreOptionsButton() {
    Icon(
        painter = painterResource(id = R.drawable.ic_dots),
        contentDescription = "dots",
        modifier = Modifier.padding(start = 120.dp)
    )
}

@Composable
fun Nickname() {
    Text(text = "Jorch", fontWeight = FontWeight.Bold, fontSize = 15.sp)
}

@Composable
fun UserName() {
    Text(text = "@jorchyeah", fontWeight = FontWeight.Light, fontSize = 15.sp)
}

@Composable
fun Avatar() {
    Image(
        painter = painterResource(id = R.drawable.img_avatar),
        contentDescription = "avatar",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )
}
