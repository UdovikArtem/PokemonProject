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
            type = listOf("Grass", "Poison"),
            imageRes = R.drawable.pokemon1
        ),
        Pokemon(
            id = 2,
            name = "Ivysaur",
            weight = 130,
            height = 10,
            type = listOf("Grass", "Poison"),
            imageRes = R.drawable.pokemon2
        ),
        Pokemon(
            id = 3,
            name = "Venusaur",
            weight = 1000,
            height = 20,
            type = listOf("Grass", "Poison"),
            imageRes = R.drawable.pokemon3
        ),
        Pokemon(
            id = 4,
            name = "Charmander",
            weight = 85,
            height = 6,
            type = listOf("Fire"),
            imageRes = R.drawable.pokemon4
        ),
        Pokemon(
            id = 5,
            name = "Charmeleon",
            weight = 190,
            height = 11,
            type = listOf("Fire"),
            imageRes = R.drawable.pokemon5
        ),
        Pokemon(
            id = 6,
            name = "Charizard",
            weight = 905,
            height = 17,
            type = listOf("Fire", "Flying"),
            imageRes = R.drawable.pokemon6
        ),
        Pokemon(
            id = 7,
            name = "Squirtle",
            weight = 90,
            height = 5,
            type = listOf("Water"),
            imageRes = R.drawable.pokemon7
        ),
        Pokemon(
            id = 8,
            name = "Wartortle",
            weight = 225,
            height = 10,
            type = listOf("Water"),
            imageRes = R.drawable.pokemon8
        ),
        Pokemon(
            id = 9,
            name = "Blastoise",
            weight = 855,
            height = 16,
            type = listOf("Water"),
            imageRes = R.drawable.pokemon9
        ),
        Pokemon(
            id = 10,
            name = "Caterpie",
            weight = 29,
            height = 3,
            type = listOf("Bug"),
            imageRes = R.drawable.pokemon10
        )
    ).associateBy { it.id })

    fun getPokemons(): List<Pokemon> = pokemons.values.toList()
    fun getPokemonById(id: Int): Pokemon? = pokemons[id]
}