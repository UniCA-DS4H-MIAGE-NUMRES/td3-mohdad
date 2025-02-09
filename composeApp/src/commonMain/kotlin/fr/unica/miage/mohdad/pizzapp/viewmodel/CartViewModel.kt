package fr.unica.miage.mohdad.pizzapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import fr.unica.miage.mohdad.pizzapp.model.CartItem
import fr.unica.miage.mohdad.pizzapp.model.Order
import fr.unica.miage.mohdad.pizzapp.model.OrderStatus
import fr.unica.miage.mohdad.pizzapp.model.Pizza
import kotlinx.datetime.Clock

class CartViewModel {
    private val _items = mutableStateOf<List<CartItem>>(emptyList())
    val items = _items
    
    val total = mutableStateOf(0.0)
    
    fun addPizza(pizza: Pizza) {
        val currentItems = _items.value.toMutableList()
        val existingItem = currentItems.find { it.pizza.id == pizza.id }
        
        if (existingItem != null) {
            val index = currentItems.indexOf(existingItem)
            currentItems[index] = existingItem.copy(quantity = existingItem.quantity + 1)
        } else {
            currentItems.add(CartItem(pizza, 1))
        }
        
        _items.value = currentItems
        updateTotal()
    }
    
    fun removePizza(pizza: Pizza) {
        val currentItems = _items.value.toMutableList()
        val existingItem = currentItems.find { it.pizza.id == pizza.id }
        
        if (existingItem != null) {
            if (existingItem.quantity > 1) {
                val index = currentItems.indexOf(existingItem)
                currentItems[index] = existingItem.copy(quantity = existingItem.quantity - 1)
            } else {
                currentItems.remove(existingItem)
            }
        }
        
        _items.value = currentItems
        updateTotal()
    }
    
    fun createOrder(): Order {
        return Order(
            id = generateOrderId(),
            items = _items.value,
            totalPrice = total.value,
            status = OrderStatus.PENDING,
            createdAt = Clock.System.now()
        )
    }
    
    private fun updateTotal() {
        total.value = _items.value.sumOf { it.total }
    }
    
    private fun generateOrderId(): Int {
        return System.currentTimeMillis().toInt()
    }
    
    fun clearCart() {
        _items.value = emptyList()
        updateTotal()
    }
}