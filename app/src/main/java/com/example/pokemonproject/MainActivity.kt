package com.example.pokemonproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pokemonproject.databinding.ActivityMainBinding
import com.example.pokemonproject.recyclerViewSetup.PokemonListAdapter
import com.example.pokemonproject.repository.PokemonRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PokemonListAdapter()

        adapter.onClick = {pokemon ->
            val intent = Intent(this, AboutPokemonActivity::class.java).apply {
                putExtra("id", pokemon.id)
            }
            this.startActivity(intent)
        }

        binding.main.adapter = adapter

        adapter.submitItems(PokemonRepository.getPokemons())

        val dividerItemDecoration = DividerItemDecoration(this, LinearLayoutManager.VERTICAL)

        ContextCompat.getDrawable(this, R.drawable.divider)
            ?.let { dividerItemDecoration.setDrawable(it) }

        binding.main.addItemDecoration(
            dividerItemDecoration
        )
    }
}