package com.example.pokedexlogin.model

sealed class PantallaAdminRutas(val ruta: String) {
    object Menu: PantallaAdminRutas("admin")
    object Anadir: PantallaAdminRutas("admin/anadir")
    object Eliminar: PantallaAdminRutas("admin/eliminar")
}