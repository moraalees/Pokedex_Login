package com.example.pokedexlogin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaAnadirPokemon(){
    var nombre by rememberSaveable { mutableStateOf("") }
    var tipo1 by rememberSaveable { mutableStateOf("") }
    var tipo2 by rememberSaveable { mutableStateOf("") }
    var region by rememberSaveable { mutableStateOf("") }
    var descripcion by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFA5053))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pokédex",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.padding(top = 100.dp)
        )
        Spacer(Modifier.height(120.dp))
        OutlinedTextField(
            value = nombre,
            onValueChange = {nombre = it},
            label = {
                Text(
                    text = "Nombre",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        OutlinedTextField(
            value = tipo1,
            onValueChange = {tipo1 = it},
            label = {
                Text(
                    text = "Tipo 1",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        OutlinedTextField(
            value = tipo2,
            onValueChange = {tipo2 = it},
            label = {
                Text(
                    text = "Tipo 2",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        OutlinedTextField(
            value = region,
            onValueChange = {region = it},
            label = {
                Text(
                    text = "Región",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        OutlinedTextField(
            value = descripcion,
            onValueChange = {descripcion = it},
            label = {
                Text(
                    text = "Descripción",
                    color = Color.Black
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        Button(
            onClick = { /* No hace nada */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ){
            Text(
                text = "Añadir Pokémon"
            )
        }
    }
}