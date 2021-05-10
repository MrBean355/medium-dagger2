package com.github.mrbean355.medium.dagger2.data

import androidx.lifecycle.LiveData

interface PokemonRepository {

    fun getPokemon(): LiveData<List<Pokemon>>

}