package fr.unica.miage.mohdad.pizzapp.utils

import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Resource

object PizzaImages {
    const val Pizza1 = "pizza1.png"
    const val Pizza2 = "pizza2.png"
    const val Pizza3 = "pizza3.png"
    const val Pizza4 = "pizza4.png"
    const val Pizza5 = "pizza5.png"
    const val Pizza6 = "pizza6.png"
    const val Pizza7 = "pizza7.png"
    const val Pizza8 = "pizza8.png"
    const val Pizza9 = "pizza9.png"
    const val Logo = "logo.png"
}

@OptIn(ExperimentalResourceApi::class)
expect object ResourceLoader {
    fun getImageResource(name: String): Resource
}