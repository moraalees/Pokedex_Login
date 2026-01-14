package com.example.pokedexlogin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pokedexlogin.ui.navigation.AppNavHost
import com.example.pokedexlogin.ui.navigation.PantallaNavegacion
import com.example.pokedexlogin.ui.screens.PantallaFiltrado
import com.example.pokedexlogin.ui.screens.PantallaPrincipal
import com.example.pokedexlogin.ui.screens.PantallaRejilla
import com.example.pokedexlogin.ui.theme.PokedexLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavHost()
        }
    }
}