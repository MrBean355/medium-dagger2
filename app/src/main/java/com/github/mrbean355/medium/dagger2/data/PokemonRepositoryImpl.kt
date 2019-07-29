package com.github.mrbean355.medium.dagger2.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

private val executor: Executor = Executors.newSingleThreadExecutor()

// A constructor annotated with @Inject tells Dagger to use it when trying to instantiate the class.
// Dagger will try to instantiate any parameters of the @Injected-annotated constructor and pass them in.
class PokemonRepositoryImpl @Inject constructor(private val service: PokemonService, private val cache: PokemonCache)
    : PokemonRepository {

    override fun getPokemon(): LiveData<List<Pokemon>> {
        val liveData = MutableLiveData<List<Pokemon>>()
        executor.execute {
            if (cache.hasData()) {
                liveData.postValue(cache.getItems())
            } else {
                val response = service.getAll().execute()
                val items = response.body()?.results.orEmpty()
                cache.saveItems(items)
                liveData.postValue(items)
            }
        }
        return liveData
    }
}