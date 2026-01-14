package com.example.pokedexlogin.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pokedexlogin.R
import com.example.pokedexlogin.model.Pantalla
import com.example.pokedexlogin.model.ObjetoUsuario

@Composable
fun FooterNavegacion(navController: NavController) {
    val pantallas = mutableListOf(
        Pantalla.Principal,
        Pantalla.Rejilla,
        Pantalla.Filtrado
    )

    if (ObjetoUsuario.esAdmin()) {
        pantallas.add(Pantalla.Admin)
    }

    NavigationBar {
        val actual = navController.currentBackStackEntryAsState().value?.destination?.route

        pantallas.forEach { pantalla ->
            val icono = when (pantalla) {
                Pantalla.Principal -> R.drawable.pokeball
                Pantalla.Rejilla -> R.drawable.superball
                Pantalla.Filtrado -> R.drawable.ultraball
                Pantalla.Admin -> R.drawable.masterball
                else -> R.drawable.pokeball
            }
            NavigationBarItem(
                selected = actual == pantalla.rutaActual,
                onClick = {
                    navController.navigate(pantalla.rutaActual
                    ) },
                icon = {
                    Image(
                        painter = painterResource(icono),
                        contentDescription = pantalla.rutaActual,
                        modifier = Modifier.size(28.dp)
                    )
                }
            )
        }
    }
}