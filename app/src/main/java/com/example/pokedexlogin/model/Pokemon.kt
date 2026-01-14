package com.example.pokedexlogin.model

import androidx.annotation.DrawableRes

data class Pokemon(
    val nombre: String,
    val tipo1: Tipos,
    val tipo2: Tipos,
    val descripcion: String,
    val generacion: Generacion,
    @DrawableRes var foto: Int
)