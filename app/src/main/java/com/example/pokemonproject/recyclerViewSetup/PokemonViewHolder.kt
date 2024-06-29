package com.example.pokemonproject.recyclerViewSetup

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokemonproject.databinding.PokemonCardBinding
import com.example.pokemonproject.model.Pokemon

class PokemonViewHolder(
    private val binding: PokemonCardBinding
) : ViewHolder(binding.root) {

    fun bind(model: Pokemon, onClick: (Pokemon) -> Unit) {
        binding.apply {
            imageView.setImageResource(model.imageRes)
            textView.text = model.name
            root.setOnClickListener { onClick(model) }
        }
    }
}