package com.example.jetpackcomponentscatalog.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import com.example.jetpackcomponentscatalog.model.Pokemon
import com.example.jetpackcomponentscatalog.model.PokemonTypes

class RecyclerViewViewModel {
    @RequiresApi(Build.VERSION_CODES.N)
    fun onChecked(
        pokemonEnabled: Pair<PokemonTypes, MutableState<Boolean>>,
        pokemonList: SnapshotStateList<Pokemon>,
        backupList: SnapshotStateList<Pokemon>
    ) {
        var pokemonListBackup = backupList
        if (!pokemonEnabled.second.value) {
            pokemonList.removeIf { pokemonEnabled.first == it.type1 }
        } else {
            pokemonListBackup = pokemonListBackup
                .filter { pokemonEnabled.first == it.type1 }
                .toMutableStateList()
            pokemonList.addAll(pokemonListBackup)
        }
        pokemonList.sortBy { it.number }
    }
}