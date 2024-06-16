package com.example.pokemonproject.model

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val type: List<String>,
    val image: Int
)