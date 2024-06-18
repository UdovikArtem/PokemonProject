package com.example.pokemonproject

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding
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


        with(binding) {
            pokemon?.let {
                binding.pokemonImage.setImageResource(it.imageRes)
                binding.name.text = it.name
                binding.weight.text = "Weight: ${it.weight} kg"
                binding.height.text = "Height: ${it.height} cm"

                binding.typeLayout.apply {
                    it.type.forEach {type ->
                        this.addView(createTypeText(type))
                    }
                }
            } ?: run {
                Log.e("pokemonIsNull", "Pokemon with ${pokemonId} is not exist")
                binding.pokemonImage.setImageResource(R.drawable.ic_launcher_background)
                binding.name.text = "Not Found"
                binding.weight.text = "Weight: Not Found"
                binding.height.text = "Height: Not Found"
                binding.typeLayout.addView(createTypeText("Not Found"))
            }
        }
        binding.backButton.setOnClickListener {
            this.finish()
        }

    }

    private fun createTypeText(type: String): TextView {
        val textView = TextView(this).apply {
            layoutParams = ViewGroup.MarginLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textSize = 20f
            text = type
            setTextColor(getColor(R.color.black))
            setPadding(5)
        }
        return textView
    }
}