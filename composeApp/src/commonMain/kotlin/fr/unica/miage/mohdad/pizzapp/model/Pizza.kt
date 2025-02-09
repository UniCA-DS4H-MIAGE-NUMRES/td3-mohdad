package fr.unica.miage.mohdad.pizzapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Pizza(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String? = null
)
