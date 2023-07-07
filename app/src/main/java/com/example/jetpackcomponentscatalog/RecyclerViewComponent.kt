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
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
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
                PokemonCard(starter)
            }
        }
    }
}

@Composable
fun PokemonCard(starter: Pokemon) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(280.dp)
            .padding(8.dp)
    ) {
        PokemonInfo(starter)
    }
}

@Composable
fun PokemonInfo(pokemon: Pokemon) {
    Column(horizontalAlignment = CenterHorizontally) {
        Image(
            painter = painterResource(id = pokemon.image),
            contentDescription = pokemon.name,
            alignment = Alignment.Center
        )
        Text(text = pokemon.number.toString())
        Text(text = pokemon.name.uppercase())
        TypesRow(pokemon)
    }
}

@Composable
fun TypesRow(pokemon: Pokemon) {
    Row {
        TypeButton(pokemon.type1)
        Spacer(modifier = Modifier.size(10.dp))
        if (pokemon.type2 != null) {
            TypeButton(pokemon.type2)
        }
    }
}

@Composable
fun TypeButton(type: PokemonTypes) {
    Button(
        onClick = { },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(type.color),
            contentColor = Color.White
        )
    ) {
        Text(text = type.toString())
    }
}

