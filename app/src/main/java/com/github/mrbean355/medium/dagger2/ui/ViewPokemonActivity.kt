package com.github.mrbean355.medium.dagger2.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import com.github.mrbean355.medium.dagger2.R
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_view_pokemon.*
import javax.inject.Inject

// To be able to inject activities and fragment, you need to create a @ContributesAndroidInjector
// method for each activity/fragment in a Dagger module (see PokemonModule).
class ViewPokemonActivity : AppCompatActivity() {
    // Ask Dagger to set this field for us.
    @Inject
    lateinit var viewModel: ViewPokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        // Performs the actual setting of the fields. Without this, the fields will be null.
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pokemon)

        val adapter = PokemonAdapter()
        recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recycler_view.adapter = adapter

        viewModel.pokemon.observe(this, Observer {
            progress_bar.visibility = View.GONE
            adapter.setItems(it)
        })
    }
}
