package com.github.mrbean355.medium.dagger2.data

data class PokemonResponse(val results: List<Pokemon>)

data class Pokemon(val name: String)