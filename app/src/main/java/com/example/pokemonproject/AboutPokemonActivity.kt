package com.example.pokemonproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pokemonproject.databinding.ActivityAboutPokemonBinding
import com.example.pokemonproject.repository.PokemonRepository

class AboutPokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutPokemonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemonId = intent.getIntExtra("id", -1)

        val pokemon = PokemonRepository.getPokemonById(pokemonId)

        if (pokemon != null) {
            binding.pokemonImage.setImageResource(pokemon.image)
            binding.nameEmpty.text = pokemon.name
            binding.weightEmpty.text = "${pokemon.weight} kg"
            binding.heightEmpty.text = "${pokemon.height} cm"
            var types = ""
            for (type in pokemon.type) {
                types += type
                if(type != pokemon.type.last()){
                    types += ", "
                }
            }
            binding.typeEmpty.text = types
        }

        binding.backButton.setOnClickListener {
            this.finish()
        }

    }
}