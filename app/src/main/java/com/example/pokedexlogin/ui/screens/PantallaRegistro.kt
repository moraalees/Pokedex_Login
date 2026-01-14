package com.example.pokedexlogin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
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
fun PantallaRegistro(
    registroCorrecto: () -> Unit,
    loginCambio: () -> Unit
) {
    var email by rememberSaveable { mutableStateOf("") }
    var nombre by rememberSaveable { mutableStateOf("") }
    var nombreUsuario by rememberSaveable { mutableStateOf("") }
    var contrasena by rememberSaveable { mutableStateOf("") }
    var error by rememberSaveable { mutableStateOf("") }

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFA5053)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Registro",
            fontSize = 42.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 100.dp)
        )
        Spacer(Modifier.height(140.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = {
                Text(
                    text = "Correo electrónico",
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
            value = nombre,
            onValueChange = { nombre = it },
            label = {
                Text(
                    text = "Nombre")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        OutlinedTextField(
            value = nombreUsuario,
            onValueChange = { nombreUsuario = it },
            label = {
                Text(
                    text = "Usuario",
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
            value = contrasena,
            onValueChange = { contrasena = it },
            label = {
                Text(
                    text = "Contraseña",
                    color = Color.Black
                )
            },
            visualTransformation = PasswordVisualTransformation(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedTextColor = Color.Black,
                unfocusedContainerColor = Color.White
            )
        )
        if (error.isNotEmpty()) {
            Text(
                text = error, color = Color.Yellow)
        }
        Spacer(Modifier.height(50.dp))
        Button(
            onClick = {
                when {
                    email.isBlank() -> {
                        error = "El correo electrónico no puede estar vacío"
                    }
                    nombre.isBlank() -> {
                        error = "El nombre no puede estar vacío"
                    }
                    nombreUsuario.isBlank() -> {
                        error = "El nombre de usuario no puede estar vacío"
                    }
                    contrasena.isBlank() -> {
                        error = "La contraseña no puede estar vacía"
                    }
                    contrasena.length < 6 -> {
                        error = "La contraseña debe tener al menos 6 caracteres"
                    }
                    else -> {
                        val success = ObjetoUsuario.registro(
                            ObjetoUsuario.Usuario(
                                email = email,
                                nombre = nombre,
                                nombreUsuario = nombreUsuario,
                                contrasena = contrasena,
                                admin = false
                            )
                        )
                        if (success) {
                            ObjetoUsuario.guardarEstado(context)
                            registroCorrecto()
                        } else {
                            error = "El usuario ya existe"
                        }
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White
            )
        ) {
            Text(
                text = "Registrarse"
            )
        }
        TextButton(
            onClick = loginCambio,
        ) {
            Text(
                text = "¿Ya tiene una cuenta? Log In",
                color = Color.Black
            )
        }
    }
}