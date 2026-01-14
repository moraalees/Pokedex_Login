package com.example.pokedexlogin.repository

import com.example.pokedexlogin.R
import com.example.pokedexlogin.model.Generacion
import com.example.pokedexlogin.model.Pokemon
import com.example.pokedexlogin.model.Tipos

class PokemonRepository {
    companion object{
        fun getPokemon(): List<Pokemon>{
            return listOf(
                Pokemon(
                    "Conkeldurr",
                    Tipos.LUCHA,
                    Tipos.LUCHA,
                    "Albañil musculoso con dos vigas de piedra",
                    Generacion.TESELIA,
                    R.drawable.conkeldurr
                ),
                Pokemon(
                    "Swampert",
                    Tipos.AGUA,
                    Tipos.TIERRA,
                    "Ajolote gigantesco apodado Terremotero",
                    Generacion.HOENN,
                    R.drawable.swampert
                ),
                Pokemon(
                    "Chandelure",
                    Tipos.FUEGO,
                    Tipos.FANTASMA,
                    "Candelabro espeluznante que alumbra la oscuridad",
                    Generacion.TESELIA,
                    R.drawable.chandelure
                ),
                Pokemon(
                    "Haxorus",
                    Tipos.DRAGON,
                    Tipos.DRAGON,
                    "Dragón que corta acero como si fuese papel",
                    Generacion.TESELIA,
                    R.drawable.haxorus
                ),
                Pokemon(
                    "Gyarados",
                    Tipos.AGUA,
                    Tipos.VOLADOR,
                    "Pez dragón titánico con bigotes",
                    Generacion.KANTO,
                    R.drawable.gyarados
                ),
                Pokemon(
                    "Krookodile",
                    Tipos.SINIESTRO,
                    Tipos.TIERRA,
                    "Cocodrilo de arena con gafas de sol",
                    Generacion.TESELIA,
                    R.drawable.krookodile
                ),
                Pokemon(
                    "Heracross",
                    Tipos.BICHO,
                    Tipos.LUCHA,
                    "Escarabajo rinoceronte con esteroides",
                    Generacion.JOHTO,
                    R.drawable.heracross
                ),
                Pokemon(
                    "Rampardos",
                    Tipos.ROCA,
                    Tipos.ROCA,
                    "Dinosaurio del jurásico que asesta cabezazos",
                    Generacion.SINNOH,
                    R.drawable.rampardos
                ),
                Pokemon(
                    "Infernape",
                    Tipos.LUCHA,
                    Tipos.FUEGO,
                    "Son Wukong de fuego inicial",
                    Generacion.SINNOH,
                    R.drawable.infernape
                ),
                Pokemon(
                    "Glastrier",
                    Tipos.HIELO,
                    Tipos.HIELO,
                    "Caballo helado con patas imponentes",
                    Generacion.GALAR,
                    R.drawable.glastrier
                ),
                Pokemon(
                    "Annihilape",
                    Tipos.LUCHA,
                    Tipos.FANTASMA,
                    "Mono fallecido lleno de ira",
                    Generacion.PALDEA,
                    R.drawable.annihilape
                ),
                Pokemon(
                    "Florges",
                    Tipos.HADA,
                    Tipos.HADA,
                    "Flor mágica que cuida la naturaleza",
                    Generacion.KALOS,
                    R.drawable.florges
                ),
                Pokemon(
                    "Salazzle",
                    Tipos.FUEGO,
                    Tipos.VENENO,
                    "Lagartija venenosa que escupe fuego",
                    Generacion.ALOLA,
                    R.drawable.salazzle
                ),
                Pokemon(
                    "Toxicroak",
                    Tipos.VENENO,
                    Tipos.LUCHA,
                    "Sapo de guerra que envenena con sus dagas",
                    Generacion.SINNOH,
                    R.drawable.toxicroak
                ),
                Pokemon(
                    "Kricketune",
                    Tipos.BICHO,
                    Tipos.BICHO,
                    "Grillo con dagas que canta icónicamente",
                    Generacion.SINNOH,
                    R.drawable.kricketune
                ),
                Pokemon(
                    "Reuniclus",
                    Tipos.PSIQUICO,
                    Tipos.PSIQUICO,
                    "Masa fetal que tiene poderes psíquicos",
                    Generacion.TESELIA,
                    R.drawable.reuniclus
                ),
                Pokemon(
                    "Staraptor",
                    Tipos.NORMAL,
                    Tipos.VOLADOR,
                    "Pájaro intimidante que mete puñetazos",
                    Generacion.SINNOH,
                    R.drawable.staraptor
                ),
                Pokemon(
                    "Beartic",
                    Tipos.HIELO,
                    Tipos.HIELO,
                    "Oso níveo cuyo pelaje es abundante",
                    Generacion.TESELIA,
                    R.drawable.beartic
                ),
                Pokemon(
                    "Rillaboom",
                    Tipos.PLANTA,
                    Tipos.PLANTA,
                    "Músico proveniente de una herboristería",
                    Generacion.GALAR,
                    R.drawable.rillaboom
                ),
                Pokemon(
                    "Metagross",
                    Tipos.ACERO,
                    Tipos.PSIQUICO,
                    "Masacote de acero que se levanta del suelo",
                    Generacion.HOENN,
                    R.drawable.metagross
                ),
            )
        }
    }
}