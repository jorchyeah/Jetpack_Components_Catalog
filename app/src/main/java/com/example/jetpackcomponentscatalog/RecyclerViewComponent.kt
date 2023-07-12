package com.example.jetpackcomponentscatalog

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpackcomponentscatalog.model.Pokemon
import com.example.jetpackcomponentscatalog.model.PokemonTypes
import com.example.jetpackcomponentscatalog.model.PokemonTypes.*
import com.example.jetpackcomponentscatalog.viewmodel.RecyclerViewViewModel

val recyclerViewViewModel = RecyclerViewViewModel()

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun MyRecyclerView() {
    val starters = getPokemon()
    Column {
        FilterButton(starters)
        Spacer(modifier = Modifier.size(8.dp))
        HorizontalRecyclerView(starters)
    }
}

@Composable
fun HorizontalRecyclerView(pokemon: SnapshotStateList<Pokemon>) {
    LazyRow {
        items(pokemon) { starter ->
            HorizontalRVPokemonCard(starter)
        }
    }
}

@Composable
fun VerticalRecyclerView(pokemon: SnapshotStateList<Pokemon>) {
    LazyColumn(horizontalAlignment = CenterHorizontally) {
        items(pokemon) { starter ->
            VerticalRVPokemonCard(starter)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun FilterButton(pokemonList: SnapshotStateList<Pokemon>) {
    val filterOptionsVisibility = rememberSaveable { mutableStateOf(false) }
    Button(
        modifier = Modifier.padding(horizontal = 8.dp),
        onClick = { filterOptionsVisibility.value = !filterOptionsVisibility.value }) {
        Text(text = "Filter")
    }
    DropdownMenu(
        expanded = filterOptionsVisibility.value,
        onDismissRequest = { filterOptionsVisibility.value = false }) {
        DropdownMenuItem(onClick = {}) {
            DropdownMenuItemContents(pokemonList)
        }
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun DropdownMenuItemContents(
    pokemonList: SnapshotStateList<Pokemon>
) {
    val grassPokemon = rememberSaveable { Pair(GRASS, mutableStateOf(true)) }
    val firePokemon = rememberSaveable { Pair(FIRE, mutableStateOf(true)) }
    val waterPokemon = rememberSaveable { Pair(WATER, mutableStateOf(true)) }
    Column(horizontalAlignment = CenterHorizontally) {
        CheckBoxOption(pokemonList, grassPokemon)
        CheckBoxOption(pokemonList, firePokemon)
        CheckBoxOption(pokemonList, waterPokemon)
    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun CheckBoxOption(
    pokemonList: SnapshotStateList<Pokemon>,
    pokemonEnabled: Pair<PokemonTypes, MutableState<Boolean>>
) {
    val pokemonListBackup = getPokemon()
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = pokemonEnabled.first.toString())
        Checkbox(
            checked = pokemonEnabled.second.value,
            onCheckedChange = {
                pokemonEnabled.second.value = !pokemonEnabled.second.value
                recyclerViewViewModel.onChecked(pokemonEnabled, pokemonList, pokemonListBackup) })
    }
}

@Composable
fun HorizontalRVPokemonCard(starter: Pokemon) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .width(250.dp)
            .height(280.dp)
            .padding(8.dp)
    ) {
        PokemonInfo(starter)
    }
}

@Composable
fun VerticalRVPokemonCard(starter: Pokemon) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
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
        pokemon.type2?.let { TypeButton(it) }
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

fun getPokemon(): SnapshotStateList<Pokemon> {
    return mutableStateListOf(
        Pokemon("Bulbasaur", 1, GRASS, POISON, R.drawable.img_pk_001),
        Pokemon("Charmander", 4, FIRE, null, R.drawable.img_pk_004),
        Pokemon("Squirtle", 7, WATER, null, R.drawable.img_pk_007),
        Pokemon("Chikorita", 152, GRASS, null, R.drawable.img_pk_152),
        Pokemon("Cyndaquil", 155, FIRE, null, R.drawable.img_pk_155),
        Pokemon("Totodile", 158, WATER, null, R.drawable.img_pk_158),
        Pokemon("Treeko", 252, GRASS, null, R.drawable.img_pk_252),
        Pokemon("Torchic", 255, FIRE, null, R.drawable.img_pk_255),
        Pokemon("Mudkip", 258, WATER, null, R.drawable.img_pk_258),
        Pokemon("Turtwig", 387, GRASS, null, R.drawable.img_pk_387),
        Pokemon("Chimchar", 390, FIRE, null, R.drawable.img_pk_390),
        Pokemon("Piplup", 393, WATER, null, R.drawable.img_pk_393),
        Pokemon("Snivy", 495, GRASS, null, R.drawable.img_pk_495),
        Pokemon("Tepig", 498, FIRE, null, R.drawable.img_pk_498),
        Pokemon("Oshawott", 501, WATER, null, R.drawable.img_pk_501),
        Pokemon("Chespin", 650, GRASS, null, R.drawable.img_pk_650),
        Pokemon("Fennekin", 653, FIRE, null, R.drawable.img_pk_653),
        Pokemon("Froakie", 656, WATER, null, R.drawable.img_pk_656),
        Pokemon("Rowlett", 722, GRASS, FLYING, R.drawable.img_pk_722),
        Pokemon("Litten", 725, FIRE, null, R.drawable.img_pk_725),
        Pokemon("Popplio", 728, WATER, null, R.drawable.img_pk_728),
        Pokemon("Grookie", 810, GRASS, null, R.drawable.img_pk_810),
        Pokemon("Scorbunny", 813, FIRE, null, R.drawable.img_pk_813),
        Pokemon("Sobble", 816, WATER, null, R.drawable.img_pk_816),
        Pokemon("Sprigatito", 906, GRASS, null, R.drawable.img_pk_906),
        Pokemon("Fuecoco", 909, FIRE, null, R.drawable.img_pk_909),
        Pokemon("Quaxly", 912, WATER, null, R.drawable.img_pk_912),
    )
}

