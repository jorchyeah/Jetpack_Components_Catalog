package com.example.jetpackcomponentscatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomponentscatalog.model.Pokemon
import com.example.jetpackcomponentscatalog.model.PokemonTypes

val starters = listOf(
    Pokemon("Bulbasaur", 1, PokemonTypes.GRASS, PokemonTypes.POISON, R.drawable.img_pk_001),
    Pokemon("Charmander", 4, PokemonTypes.FIRE, null, R.drawable.img_pk_004),
    Pokemon("Squirtle", 7, PokemonTypes.WATER, null, R.drawable.img_pk_007),
)

@Composable
fun MyRecyclerView() {
    LazyRow {
        starters.forEach { starter ->
            item {
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(280.dp)
                        .padding(8.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = starter.image),
                            contentDescription = starter.name,
                            alignment = Alignment.Center
                        )
                        Text(text = starter.number.toString())
                        Text(text = starter.name.uppercase())
                        Row {
                            Button(
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color(starter.type1.color),
                                    contentColor = Color.White
                                )
                            ) {
                                Text(text = starter.type1.toString())
                            }
                            Spacer(modifier = Modifier.size(10.dp))
                            if (starter.type2 != null) {
                                Button(
                                    onClick = { },
                                    colors = ButtonDefaults.buttonColors(
                                        backgroundColor = Color(starter.type2.color),
                                        contentColor = Color.White
                                    )
                                ) {
                                    Text(text = starter.type2.toString())
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}