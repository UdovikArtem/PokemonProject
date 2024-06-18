package com.example.pokemonproject

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.GridLayout.TEXT_ALIGNMENT_CENTER
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import com.example.pokemonproject.databinding.ActivityMainBinding
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
        val cardView = CardView(this).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(dpToPx(10))
            }
            setCardBackgroundColor(getColor(R.color.orange))
            radius = 20f
            setOnClickListener {
                val intent = Intent(
                    this@MainActivity,
                    AboutPokemonActivity::class.java).apply {
                            putExtra("id", pokemon.id)
                    }
                this@MainActivity.startActivity(intent)
            }
        }

        val linearLayout = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                dpToPx(100)
            )
        }

        val imageView = ImageView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                2f
            )
            setImageResource(pokemon.imageRes)
        }

        val textView = TextView(this).apply {
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,
                1f
            )
            gravity = Gravity.CENTER
            text = pokemon.name
            textSize = 40f
            setTextColor(getColor(R.color.white))
            textAlignment = TEXT_ALIGNMENT_CENTER
        }

        linearLayout.apply {
            addView(imageView)
            addView(textView)
        }
        cardView.addView(linearLayout)

        return cardView
    }

    private fun dpToPx(dp: Int): Int {
        return (dp*resources.displayMetrics.density).toInt()
    }
}