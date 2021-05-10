package com.github.mrbean355.medium.dagger2.data

import retrofit2.Call
import retrofit2.http.GET

interface PokemonService {

    @GET("pokemon?limit=999")
    fun getAll(): Call<PokemonResponse>

}