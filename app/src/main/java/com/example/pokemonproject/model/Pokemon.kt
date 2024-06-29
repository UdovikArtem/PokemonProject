package com.example.pokemonproject.model

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val type: List<String>,
    @DrawableRes val imageRes: Int
)