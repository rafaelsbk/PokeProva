package projeto.pdm.terceiraprova.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import projeto.pdm.terceiraprova.R
import projeto.pdm.terceiraprova.model.Pokemon
import projeto.pdm.terceiraprova.model.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)
        val  bulba = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            1,
            "Bulba",
            listOf(
                PokemonType("Pranta")
            )
        )
        val pokemon = listOf(
            bulba,bulba, bulba, bulba, bulba, bulba
        )
        val layoutManager = LinearLayoutManager(this)

        recyclerView.adapter = AdapterPoke(pokemon)

    }
}