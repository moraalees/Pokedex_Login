package com.example.pokedexlogin.model

data class SesionPersistida(
    val usuarioActual: String?,
    val usuarios: List<ObjetoUsuario.Usuario>
)