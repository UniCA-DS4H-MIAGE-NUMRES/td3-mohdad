package fr.unica.miage.mohdad.pizzapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CartItem(
    val pizza: Pizza,
    val quantity: Int
) {
    val total: Double
        get() = pizza.price * quantity
}