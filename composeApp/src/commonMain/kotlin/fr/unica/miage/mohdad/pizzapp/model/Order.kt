package fr.unica.miage.mohdad.pizzapp.model

import kotlinx.serialization.Serializable
import kotlinx.datetime.Instant

@Serializable
data class Order(
    val id: Int,
    val items: List<CartItem>,
    val totalPrice: Double,
    val status: OrderStatus,
    val createdAt: Instant
)

@Serializable
enum class OrderStatus {
    PENDING,
    CONFIRMED,
    IN_PREPARATION,
    READY,
    DELIVERED
}