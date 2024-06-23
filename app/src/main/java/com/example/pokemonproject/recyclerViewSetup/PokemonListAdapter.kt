package com.example.pokemonproject.recyclerViewSetup

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonproject.databinding.PokemonCardBinding
import com.example.pokemonproject.model.Pokemon

class PokemonListAdapter: RecyclerView.Adapter<PokemonViewHolder>() {

    private var items = emptyList<Pokemon>()

    private val differ = AsyncListDiffer(this, DiffCallback)

    var onClick: (Pokemon) -> Unit = { }

    fun submitItems(newItems: List<Pokemon>){
        items = newItems
        differ.submitList(newItems)
    }

    override fun getItemCount(): Int = differ.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder(
            PokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        holder.bind(items[position], onClick)
    }
}