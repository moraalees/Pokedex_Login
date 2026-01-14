package com.example.pokedexlogin.ui.data

import android.content.Context
import com.example.pokedexlogin.model.SesionPersistida
import com.google.gson.Gson
import java.io.File

object SesionJsonManager {
    private const val FILE_NAME = "usuarios.json"
    private val gson = Gson()

    private fun obtenerArchivoJson(context: Context): File {
        return File(context.filesDir, FILE_NAME)
    }

    fun guardar(context: Context, sesion: SesionPersistida) {
        val json = gson.toJson(sesion)
        obtenerArchivoJson(context).writeText(json)
    }

    fun cargar(context: Context): SesionPersistida? {
        val file = obtenerArchivoJson(context)
        if (!file.exists()) return null
        return gson.fromJson(file.readText(), SesionPersistida::class.java)
    }

    fun borrarSesion(context: Context) {
        val sesion = cargar(context) ?: return
        guardar(
            context,
            sesion.copy(usuarioActual = null)
        )
    }
}
