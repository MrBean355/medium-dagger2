package com.github.mrbean355.medium.dagger2.data

import javax.inject.Inject
import javax.inject.Singleton

// @Singleton ensures Dagger only instantiates this class once.
// Note: there can still be multiple instances of this class if the constructor is called manually.
@Singleton
class PokemonCache @Inject constructor() {
    private var items: List<Pokemon>? = null

    fun hasData(): Boolean {
        return synchronized(this) {
            items != null
        }
    }

    fun getItems(): List<Pokemon> {
        return synchronized(this) {
            items.orEmpty()
        }
    }

    fun saveItems(newItems: List<Pokemon>) {
        synchronized(this) {
            items = newItems
        }
    }
}