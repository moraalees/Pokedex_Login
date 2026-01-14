package com.example.pokedexlogin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexlogin.model.ObjetoUsuario
import com.example.pokedexlogin.repository.PokemonRepository
import com.example.pokedexlogin.ui.components.PokemonComponent

@Composable
fun PantallaPrincipal(
    onLogout: () -> Unit
) {
    val context = LocalContext.current

    val pokemonAleatorio = remember {
        PokemonRepository.getPokemon().random()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFA5053))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = {
                    ObjetoUsuario.logout(context)
                    onLogout()
                }
            ) {
                Text(
                    text = "Cerrar sesión",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Text(
            text = "Pokédex",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Spacer(Modifier.height(80.dp))
        Text(
            text = "Bienvenido al mundo Pokémon. En esta Pokédex se hallan los mejores Pokémon que existen en esta saga.",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(40.dp))
        Text(
            text = "El mejor Pokémon de todos los tiempos es:",
            fontSize = 20.sp,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(20.dp))
        PokemonComponent(pokemon = pokemonAleatorio)
    }
}
