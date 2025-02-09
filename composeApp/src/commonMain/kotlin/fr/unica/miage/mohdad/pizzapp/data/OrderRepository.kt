package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.model.OrderEntity
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    fun getAllOrders(): Flow<List<OrderEntity>>
    suspend fun insertOrder(order: OrderEntity)
    suspend fun clearOrders()
}