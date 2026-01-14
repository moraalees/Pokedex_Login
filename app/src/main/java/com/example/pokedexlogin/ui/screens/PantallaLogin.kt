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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexlogin.model.ObjetoUsuario

@Composable
fun PantallaLogin(
    loginCorrecto: () -> Unit,
    botonRegistro: () -> Unit
) {
    var usuario by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }

    val contexto = LocalContext.current
    if (ObjetoUsuario.login(usuario, contrasena)) {
        ObjetoUsuario.guardarEstado(contexto)
        loginCorrecto()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFA5053)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pokédex",
            fontSize = 42.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 100.dp)
        )
        Spacer(Modifier.height(140.dp))
        OutlinedTextField(
            value = usuario,
            onValueChange = { usuario = it },
            label = { Text("Nombre de usuario", color = Color.Black) },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        Spacer(Modifier.height(20.dp))
        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña", color = Color.Black) },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        if (error.isNotEmpty()) {
            Text(
                text = error,
                color = Color.Yellow
            )
        }
        Spacer(Modifier.height(100.dp))
        Button(
            onClick = {
                if (ObjetoUsuario.login(usuario, contrasena)) {
                    loginCorrecto()
                } else {
                    error = "Usuario o contraseña incorrectos"
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Log In"
            )
        }

        TextButton(
            onClick = botonRegistro
        ) {
            Text(
                text = "¿No tiene una cuenta? Registrarse",
                color = Color.Black
            )
        }
    }
}