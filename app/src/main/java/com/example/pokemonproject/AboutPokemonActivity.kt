package com.example.pokemonproject

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
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
                pokemonImage.setImageResource(it.imageRes)
                name.text = it.name
                weight.text = "Weight: ${it.weight} kg"
                height.text = "Height: ${it.height} cm"

                typeLayout.apply {
                    it.type.forEach {type ->
                        this.addView(createTypeText(type))
                    }
                }
            } ?: run {
                Log.e("pokemonIsNull", "Pokemon with ${pokemonId} is not exist")
                pokemonImage.setImageResource(R.drawable.ic_launcher_background)
                name.text = "Not Found"
                weight.text = "Weight: Not Found"
                height.text = "Height: Not Found"
                typeLayout.addView(createTypeText("Not Found"))
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
            setPadding(TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                5f,
                resources.displayMetrics).toInt())
        }
        return textView
    }
}