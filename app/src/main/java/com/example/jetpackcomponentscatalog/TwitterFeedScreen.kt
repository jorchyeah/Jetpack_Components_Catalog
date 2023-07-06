package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val twitterFeedViewModel = TwitterFeedViewModel()

@Composable
fun TwitterFeedScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
    ) {
        Header()
        Body()
        Footer()
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
fun Body() {
    TweetContent()
    TweetImage()
}

@Composable
fun Footer() {
    val isChatIconClicked = remember {
        Triple(
            "chatIcon",
            mutableStateOf(false),
            mutableStateOf(R.drawable.ic_chat)
        )
    }
    val isRetweetIconClicked = remember {
        Triple(
            "retweetIcon",
            mutableStateOf(false),
            mutableStateOf(R.drawable.ic_rt)
        )
    }
    val isLikeIconClicked = remember {
        Triple(
            "likeIcon",
            mutableStateOf(false),
            mutableStateOf(R.drawable.ic_like)
        )
    }
    Column() {
        Row(modifier = Modifier.padding(top = 300.dp, start = 70.dp)) {
            TweetIcons(isChatIconClicked, 49)
            Spacer(modifier = Modifier.padding(start = 50.dp))
            TweetIcons(isRetweetIconClicked, 20)
            Spacer(modifier = Modifier.padding(start = 50.dp))
            TweetIcons(isLikeIconClicked, 100)
        }
        Divider(modifier = Modifier.padding(top = 10.dp), thickness = 2.dp)
    }
}

@Composable
fun TweetIcons(
    iconClicked: Triple<String, MutableState<Boolean>, MutableState<Int>>,
    clicks: Int
) {
    val color = remember { mutableStateOf(Color.Black) }
    val counter = remember { mutableStateOf(clicks) }
    Row(modifier = Modifier.clickable {
        iconClicked.second.value = !iconClicked.second.value
        twitterFeedViewModel.iconChooser(iconClicked)
        counter.value = twitterFeedViewModel.clickCounter(clicks, iconClicked)
        color.value = twitterFeedViewModel.colorChooser(iconClicked)
    }) {
        Icon(
            painter = painterResource(id = iconClicked.third.value),
            contentDescription = iconClicked.first,
            tint = color.value
        )
        Text(text = counter.value.toString())
    }
}

@Composable
fun TweetImage() {
    Image(
        painter = painterResource(id = R.drawable.img_wolf),
        contentDescription = "Tweet Image",
        modifier = Modifier
            .size(300.dp)
            .padding(top = 120.dp, start = 70.dp),
        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun TweetContent() {
    Box(modifier = Modifier.padding(start = 70.dp, top = 30.dp, end = 35.dp)) {
        Text(
            text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
            textAlign = TextAlign.Justify
        )
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
