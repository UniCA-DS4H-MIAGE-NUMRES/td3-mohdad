package fr.unica.miage.mohdad.pizzapp.viewmodel

import androidx.compose.runtime.mutableStateListOf
import fr.unica.miage.mohdad.pizzapp.data.OrderRepository
import fr.unica.miage.mohdad.pizzapp.model.Order

class OrderHistoryViewModel(private val repository: OrderRepository) {
    private val _orders = mutableStateListOf<Order>()
    val orders: List<Order> get() = _orders

    suspend fun loadOrders() {
        _orders.clear()
        _orders.addAll(repository.getAllOrders())
    }

    suspend fun addOrder(order: Order) {
        repository.addOrder(order)
        loadOrders()
    }
    suspend fun clearHistory() {
        // Add this method to your OrderRepository interface
        repository.clearAllOrders()
        loadOrders()
    }
}