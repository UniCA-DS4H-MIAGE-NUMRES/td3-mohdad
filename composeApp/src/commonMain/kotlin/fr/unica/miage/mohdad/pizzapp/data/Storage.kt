package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.multiplatform.model.OrderEntity
import kotlinx.coroutines.flow.Flow

interface Storage {
    fun getAllOrders(): Flow<List<OrderEntity>>
    suspend fun insertOrder(order: OrderEntity)
    suspend fun clearOrders()
}
