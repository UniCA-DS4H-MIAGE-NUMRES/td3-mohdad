package fr.unica.miage.mohdad.pizzapp.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pizza(
    val name: String,
    val price: Double,
    val image: Int
)

data class OrderEntity(
    val id: Int = 0,
    val dateTime: Long,
    val pizzaName: String,
    val extraCheese: Int,
    val price: Double
)