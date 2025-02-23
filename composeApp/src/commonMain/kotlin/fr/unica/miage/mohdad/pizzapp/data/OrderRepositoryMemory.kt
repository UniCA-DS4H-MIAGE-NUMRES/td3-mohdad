package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.model.Order

class OrderRepositoryMemory : OrderRepository {
    private val orders = mutableListOf<Order>()
    private var nextId = 1

    override suspend fun addOrder(order: Order) {
        orders.add(order.copy(id = nextId++))
    }

    override suspend fun getAllOrders(): List<Order> {
        return orders.toList()
    }

    override suspend fun clearAllOrders() {
        orders.clear()
    }
}