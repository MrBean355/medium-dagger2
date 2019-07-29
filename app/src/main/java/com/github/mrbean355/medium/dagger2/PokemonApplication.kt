package com.github.mrbean355.medium.dagger2

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

// Implement HasAndroidInjector to allow Android components (e.g. activities) to be injected.
class PokemonApplication : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        // Reference the generated AppComponent implementation and construct it.
        DaggerAppComponent.create()
                .inject(this)
    }

    override fun androidInjector() = androidInjector
}