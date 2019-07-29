package com.github.mrbean355.medium.dagger2

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

// This is what links all the dependencies from your modules together.
// Compilation will fail if you inject an object that is not provided anywhere.
@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    PokemonModule::class
])
interface AppComponent : AndroidInjector<PokemonApplication>