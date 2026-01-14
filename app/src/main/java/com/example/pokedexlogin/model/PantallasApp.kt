package com.example.pokedexlogin.model

sealed class PantallasApp(val ruta: String) {
    object Login: PantallasApp("login")
    object Registro: PantallasApp("register")
    object Home: PantallasApp("home")
}