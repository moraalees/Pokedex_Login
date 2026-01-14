package com.example.pokedexlogin.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexlogin.model.Pokemon
import com.example.pokedexlogin.model.Tipos
import com.example.pokedexlogin.repository.PokemonRepository
import com.example.pokedexlogin.ui.components.PokemonComponent

val pokemons = PokemonRepository.getPokemon()

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PantallaFiltrado() {
    val pokemonPorTipo = remember {
        agruparPokemonPorTipoCompleto(pokemons)
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFA5053))
            .padding(horizontal = 16.dp)
    ) {
        item {
            Text(
                text = "Pokédex",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 24.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        pokemonPorTipo.forEach { (tipo, listaPokemon) ->
            stickyHeader {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(tipo.color)
                        .padding(12.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = tipo.name,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                }
            }

            if (listaPokemon.isEmpty()) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "No hay Pokémon de tipo ${tipo.name}",
                            color = Color.White,
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            } else {
                items(listaPokemon.chunked(2)) { fila ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        fila.forEach { pokemon ->
                            PokemonComponent(pokemon = pokemon)
                        }
                        if (fila.size == 1) {
                            Spacer(modifier = Modifier.width(200.dp))
                        }
                    }
                }
            }
        }
    }
}


private fun agruparPokemonPorTipoCompleto(listaPokemon: List<Pokemon>): Map<Tipos, List<Pokemon>> {
    val mapa = Tipos.entries.associateWith { mutableListOf<Pokemon>() }

    listaPokemon.forEach { pokemon ->
        val tiposUnicos = setOf(pokemon.tipo1, pokemon.tipo2)
        tiposUnicos.forEach { tipo ->
            mapa[tipo]?.add(pokemon)
        }
    }
    return mapa
}
