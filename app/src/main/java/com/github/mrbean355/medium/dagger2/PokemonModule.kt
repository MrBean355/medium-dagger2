package com.github.mrbean355.medium.dagger2

import com.github.mrbean355.medium.dagger2.data.PokemonRepository
import com.github.mrbean355.medium.dagger2.data.PokemonRepositoryImpl
import com.github.mrbean355.medium.dagger2.data.PokemonService
import com.github.mrbean355.medium.dagger2.ui.ViewPokemonActivity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// A Dagger "module" is a class that tells Dagger how to satisfy various dependencies.
@Module
abstract class PokemonModule {

    // Tell Dagger to generate code to make ViewPokemonActivity injectable.
    // This method is never used at runtime; Dagger only looks at the return type and generates code.
    // The method name does not matter; it is for your sanity.
    @ContributesAndroidInjector
    abstract fun contributeViewPokemonActivity(): ViewPokemonActivity

    // Tell Dagger whenever the PokemonRepository interface is injected, it should instantiate the concrete PokemonRepositoryImpl instead.
    // This method is never used at runtime; Dagger only looks at the parameter and return types and generates code.
    // The method name does not matter; it is for your sanity.
    @Binds
    abstract fun bindPokemonRepository(impl: PokemonRepositoryImpl): PokemonRepository

    companion object {

        // We can provide method bodies that construct more complicated dependencies.
        // This method will be directly called by Dagger when someone injects a PokemonService.
        @Provides
        fun providePokemonService(): PokemonService {
            return Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(PokemonService::class.java)
        }
    }
}