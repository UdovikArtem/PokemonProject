package com.example.pokemonproject.repository

import com.example.pokemonproject.R
import com.example.pokemonproject.model.Pokemon

object PokemonRepository {
    private val pokemons: HashMap<Int, Pokemon> = HashMap(listOf(
        Pokemon(
            id = 1,
            name = "Bulbasaur",
            weight = 69,
            height = 7,
            type = listOf("Grass","Poison"),
            image = R.drawable.pokemon1
        ),
        Pokemon(
            id = 2,
            name = "Ivysaur",
            weight = 130,
            height = 10,
            type = listOf("Grass","Poison"),
            image = R.drawable.pokemon2
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            weight = 1000,
            height = 20,
            type = listOf("Grass","Poison"),
            image = R.drawable.pokemon3
        ),
        Pokemon(
            id = 4,
            name = "Charmander",
            weight = 85,
            height = 6,
            type = listOf("Fire"),
            image = R.drawable.pokemon4
        ),
        Pokemon(
            id = 5,
            name = "Charmeleon",
            weight = 190,
            height = 11,
            type = listOf("Fire"),
            image = R.drawable.pokemon5
        )
    ).associateBy { it.id })

    fun getPokemonById(id: Int): Pokemon?{
        return pokemons[id]
    }
}