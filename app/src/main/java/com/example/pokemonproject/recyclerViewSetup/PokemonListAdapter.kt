package com.example.pokemonproject.recyclerViewSetup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonproject.databinding.PokemonCardBinding
import com.example.pokemonproject.model.Pokemon

class PokemonListAdapter : RecyclerView.Adapter<PokemonViewHolder>() {

    private val differ = AsyncListDiffer(this, DiffCallback)

    var onClick: (Pokemon) -> Unit = { }

    fun submitItems(newItems: List<Pokemon>) {
        differ.submitList(newItems)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(differ.currentList[position], onClick)
    }
}