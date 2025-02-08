package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.multiplatform.model.OrderEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class WebStorage : Storage {
    private val storage = kotlinx.browser.localStorage
    private val json = Json { ignoreUnknownKeys = true }

    override fun getAllOrders(): Flow<List<OrderEntity>> = flow {
        val ordersJson = storage.getItem(ORDERS_KEY) ?: "[]"
        val orders = json.decodeFromString<List<OrderEntity>>(ordersJson)
        emit(orders)
    }

    override suspend fun insertOrder(order: OrderEntity) {
        val orders = getAllOrders().first().toMutableList()
        orders.add(order)
        storage.setItem(ORDERS_KEY, json.encodeToString(orders))
    }

    override suspend fun clearOrders() {
        storage.removeItem(ORDERS_KEY)
    }

    companion object {
        private const val ORDERS_KEY = "orders"
    }
}
