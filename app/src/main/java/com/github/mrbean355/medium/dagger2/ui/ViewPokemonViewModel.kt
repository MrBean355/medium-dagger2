package com.github.mrbean355.medium.dagger2.ui

import com.github.mrbean355.medium.dagger2.data.PokemonRepository
import javax.inject.Inject

// A constructor annotated with @Inject tells Dagger to use it when trying to instantiate the class.
// Dagger will try to instantiate any parameters of the @Injected-annotated constructor and pass them in.
class ViewPokemonViewModel @Inject constructor(pokemonRepository: PokemonRepository) {
    val pokemon = pokemonRepository.getPokemon()
}