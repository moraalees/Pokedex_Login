package com.example.pokedexlogin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pokedexlogin.model.ObjetoUsuario
import com.example.pokedexlogin.model.PantallasApp
import com.example.pokedexlogin.ui.screens.PantallaLogin
import com.example.pokedexlogin.ui.screens.PantallaRegistro

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        ObjetoUsuario.cargarEstado(context)

        if (ObjetoUsuario.usuarioActual != null) {
            navController.navigate(PantallasApp.Home.ruta) {
                popUpTo(PantallasApp.Login.ruta) { inclusive = true }
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = PantallasApp.Login.ruta
    ) {
        composable(PantallasApp.Login.ruta) {
            PantallaLogin(
                loginCorrecto = {
                    navController.navigate(PantallasApp.Home.ruta) {
                        popUpTo(PantallasApp.Login.ruta) { inclusive = true }
                    }
                },
                botonRegistro = {
                    navController.navigate(PantallasApp.Registro.ruta)
                }
            )
        }

        composable(PantallasApp.Registro.ruta) {
            PantallaRegistro(
                registroCorrecto = {
                    navController.navigate(PantallasApp.Home.ruta) {
                        popUpTo(PantallasApp.Login.ruta) { inclusive = true }
                    }
                },
                loginCambio = {
                    navController.popBackStack()
                }
            )
        }

        composable(PantallasApp.Home.ruta) {
            val context = LocalContext.current
            PantallaNavegacion(
                onLogout = {
                    ObjetoUsuario.logout(context)
                    navController.navigate(PantallasApp.Login.ruta) {
                        popUpTo(PantallasApp.Home.ruta) { inclusive = true }
                    }
                }
            )
        }
    }
}

