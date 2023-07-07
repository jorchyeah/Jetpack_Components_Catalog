package com.example.jetpackcomponentscatalog.model

import androidx.annotation.DrawableRes

data class Pokemon(
    val name: String,
    val number: Int,
    val type1: PokemonTypes,
    val type2: PokemonTypes? = null,
    @DrawableRes val image: Int
)
