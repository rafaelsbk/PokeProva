package projeto.pdm.terceiraprova.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import projeto.pdm.terceiraprova.R
import projeto.pdm.terceiraprova.api.PokemonResult
import projeto.pdm.terceiraprova.api.RepositoryPoke
import projeto.pdm.terceiraprova.model.Pokemon
import projeto.pdm.terceiraprova.viewmodel.PokemonViewModel
import projeto.pdm.terceiraprova.viewmodel.PokemonViewModelFactory

class MainActivity : AppCompatActivity() {
    private val recyclerView by lazy {
        findViewById<RecyclerView>(R.id.rvPokemon)
    }

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.pokemons.observe(this, Observer {
            loadRecyclerView(it as List<Pokemon>)
        })
    }

    private fun loadRecyclerView(pokemons: List<Pokemon>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterPoke(pokemons)
    }
}