package com.example.pokemonproject.recyclerViewSetup

import androidx.recyclerview.widget.DiffUtil
import com.example.pokemonproject.model.Pokemon

object DiffCallback : DiffUtil.ItemCallback<Pokemon>() {

    override fun areItemsTheSame(oldPokemon: Pokemon, newPokemon: Pokemon) =
        oldPokemon.id == newPokemon.id

    override fun areContentsTheSame(oldPokemon: Pokemon, newPokemon: Pokemon) =
        oldPokemon == newPokemon
}