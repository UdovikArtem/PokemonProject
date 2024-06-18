package com.example.pokemonproject

import android.content.Intent
import android.os.Bundle
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import com.example.pokemonproject.databinding.ActivityMainBinding
import com.example.pokemonproject.databinding.PokemonCardBinding
import com.example.pokemonproject.model.Pokemon
import com.example.pokemonproject.repository.PokemonRepository

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pokemons = PokemonRepository.getPokemons()

        binding.main.apply {
            pokemons.forEach {
                addView(createPokemonCard(it.value))
            }
        }
    }

    private fun createPokemonCard(pokemon: Pokemon): CardView {

        val cardBinding = PokemonCardBinding.inflate(LayoutInflater.from(this))

        val cardView = cardBinding.cardView.apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(dpToPx(10))
            }
            setOnClickListener {
                val intent = Intent(
                    this@MainActivity,
                    AboutPokemonActivity::class.java
                ).apply {
                    putExtra("id", pokemon.id)
                }
                this@MainActivity.startActivity(intent)
            }
        }

        with(cardBinding){
            imageView.setImageResource(pokemon.imageRes)
            textView.text = pokemon.name
        }

        return cardView
    }

    private fun dpToPx(dp: Int): Int {
        return TypedValue.applyDimension(
            COMPLEX_UNIT_DIP,
            dp + 0.5f,
            resources.displayMetrics).toInt()
    }
}