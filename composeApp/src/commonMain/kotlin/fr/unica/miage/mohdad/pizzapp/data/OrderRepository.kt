package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.model.Order

interface OrderRepository {
    suspend fun addOrder(order: Order)
    suspend fun getAllOrders(): List<Order>
    suspend fun clearAllOrders()
}