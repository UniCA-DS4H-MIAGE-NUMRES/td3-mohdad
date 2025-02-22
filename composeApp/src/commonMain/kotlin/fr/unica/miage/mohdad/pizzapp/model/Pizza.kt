package fr.unica.miage.mohdad.pizzapp.model

import org.jetbrains.compose.resources.DrawableResource

data class Pizza(
    val id: Int,
    val name: String,
    val imageResource: DrawableResource,
    val price: Double,
    val ingredients: List<String>
)