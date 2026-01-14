package com.example.pokedexlogin.model

import android.content.Context
import com.example.pokedexlogin.ui.data.SesionJsonManager

object ObjetoUsuario {
    data class Usuario(
        val email: String = "",
        val nombre: String = "",
        val nombreUsuario: String,
        val contrasena: String,
        val admin: Boolean = false
    )

    private val usuarioAdmin = Usuario(
        nombreUsuario = "usuarioAdmin",
        contrasena = "123456",
        admin = true
    )

    private val usuariosRegistrados = mutableListOf<Usuario>()

    var usuarioActual: Usuario? = null
        private set

    init {
        usuariosRegistrados.add(usuarioAdmin)
    }

    fun login(nombreUsuario: String, contrasena: String): Boolean {
        val usuario = usuariosRegistrados.find {
            it.nombreUsuario == nombreUsuario && it.contrasena == contrasena
        }
        usuarioActual = usuario
        return usuario != null
    }

    fun registro(usuario: Usuario): Boolean {
        if (usuariosRegistrados.any { it.nombreUsuario == usuario.nombreUsuario }) {
            return false
        }
        usuariosRegistrados.add(usuario)
        usuarioActual = usuario
        return true
    }

    fun esAdmin(): Boolean = usuarioActual?.admin == true

    fun guardarEstado(context: Context) {
        SesionJsonManager.guardar(
            context,
            SesionPersistida(
                usuarioActual = usuarioActual?.nombreUsuario,
                usuarios = usuariosRegistrados
            )
        )
    }

    fun cargarEstado(context: Context) {
        val sesion = SesionJsonManager.cargar(context) ?: return
        usuariosRegistrados.clear()
        usuariosRegistrados.addAll(sesion.usuarios)

        usuarioActual = sesion.usuarioActual?.let { nombre ->
            usuariosRegistrados.find { it.nombreUsuario == nombre }
        }
    }

    fun logout(context: Context) {
        usuarioActual = null
        SesionJsonManager.borrarSesion(context)
    }
}