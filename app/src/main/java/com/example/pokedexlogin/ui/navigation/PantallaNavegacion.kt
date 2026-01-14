package com.example.pokedexlogin.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexlogin.model.Pantalla
import com.example.pokedexlogin.model.PantallaAdminRutas
import com.example.pokedexlogin.ui.screens.PantallaAnadirPokemon
import com.example.pokedexlogin.ui.screens.PantallaEliminarPokemon
import com.example.pokedexlogin.ui.screens.PantallaFiltrado
import com.example.pokedexlogin.ui.screens.PantallaPrincipal
import com.example.pokedexlogin.ui.screens.PantallaRejilla

@Composable
fun PantallaNavegacion(
    onLogout: () -> Unit
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            FooterNavegacion(navController)
        }
    ) { paddingValues ->

        NavHost(
            navController = navController,
            startDestination = Pantalla.Principal.rutaActual,
            modifier = Modifier.padding(paddingValues)
        ) {

            composable(Pantalla.Principal.rutaActual) {
                PantallaPrincipal(
                    onLogout = onLogout
                )
            }

            composable(Pantalla.Rejilla.rutaActual) {
                PantallaRejilla()
            }

            composable(Pantalla.Filtrado.rutaActual) {
                PantallaFiltrado()
            }

            composable(PantallaAdminRutas.Menu.ruta) {
                PantallaAdmin(navController)
            }

            composable(PantallaAdminRutas.Anadir.ruta) {
                PantallaAnadirPokemon()
            }

            composable(PantallaAdminRutas.Eliminar.ruta) {
                PantallaEliminarPokemon()
            }
        }
    }
}