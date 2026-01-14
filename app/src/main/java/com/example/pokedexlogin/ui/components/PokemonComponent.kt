package com.example.pokedexlogin.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexlogin.model.Pokemon

@Composable
fun PokemonComponent(
    pokemon: Pokemon
) {
    var mostrarDialog by rememberSaveable() { mutableStateOf(false) }

    Card (
        modifier = Modifier
            .height(270.dp)
            .width(180.dp)
            .clickable {mostrarDialog = true}
            .padding(16.dp),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = pokemon.foto),
                contentDescription = "Imagen del Pokémon",
                modifier = Modifier.size(130.dp)
            )
            Text(
                text = pokemon.nombre,
                fontSize = 25.sp
            )
            Spacer(Modifier.height(15.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                Text(
                    text = pokemon.tipo1.toString(),
                    fontSize = 13.sp
                )
                Spacer(Modifier.width(5.dp))
                Text(
                    text = pokemon.tipo2.toString(),
                    fontSize = 13.sp
                )
            }
        }
    }

    if (mostrarDialog) {
        AlertDialog(
            onDismissRequest = { mostrarDialog = false },
            confirmButton = {
                TextButton(onClick = { mostrarDialog = false }) {
                    Text("Cerrar")
                }
            },
            title = { Text(text = pokemon.nombre) },
            text = {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = pokemon.foto),
                        contentDescription = "Imagen del Pokémon",
                        modifier = Modifier.size(150.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("Tipo 1: ${pokemon.tipo1}")
                    Text("Tipo 2: ${pokemon.tipo2}")
                    Text("Generación: ${pokemon.generacion}")
                    Spacer(Modifier.height(8.dp))
                    Text(
                        text = pokemon.descripcion,
                        textAlign = TextAlign.Center
                    )
                }
            }
        )
    }
}