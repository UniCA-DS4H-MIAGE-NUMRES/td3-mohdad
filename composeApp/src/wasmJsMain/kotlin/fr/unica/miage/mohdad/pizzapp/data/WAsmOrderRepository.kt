package fr.unica.miage.mohdad.pizzapp.data



import fr.unica.miage.mohdad.pizzapp.model.Order
import kotlinx.browser.localStorage
import kotlinx.browser.window


class WasmOrderRepository : OrderRepository {
    private val storage = window.localStorage
    private val ordersKey = "pizzapp_orders"

    override suspend fun addOrder(order: Order) {
        try {
            val currentOrders = getAllOrders().toMutableList()
            currentOrders.add(order)
            val ordersString = currentOrders.map { orderToString(it) }.toString()
            storage.setItem(ordersKey, ordersString)
        } catch (e: Exception) {
            localStorage.clear()
        }
    }

    override suspend fun getAllOrders(): List<Order> {
        return try {
            val ordersString = storage.getItem(ordersKey)
            if (ordersString != null && ordersString.isNotEmpty()) {
                // Enlever les crochets du début et de la fin
                val content = ordersString.substring(1, ordersString.length - 1)
                if (content.isEmpty()) return emptyList()

                // Séparer les ordres et les convertir
                content.split(", ").map { stringToOrder(it) }
            } else {
                emptyList()
            }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun clearAllOrders() {
        storage.removeItem(ordersKey)
    }

    private fun orderToString(order: Order): String {
        return "${order.id}|${order.pizzaName}|${order.price}|${order.extraCheese}"
    }

    private fun stringToOrder(str: String): Order {
        val parts = str.split("|")
        return Order(
            id = parts[0].toInt(),
            pizzaName = parts[1],
            price = parts[2].toDouble(),
            extraCheese = parts[3].toInt()
        )
    }
}