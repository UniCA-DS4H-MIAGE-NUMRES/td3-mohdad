package fr.unica.miage.mohdad.pizzapp.data

import android.content.Context
import androidx.room.Room
import fr.unica.miage.mohdad.pizzapp.model.Order
import fr.unica.miage.mohdad.pizzapp.model.OrderEntity

class AndroidOrderRepository(context: Context) : OrderRepository {
    private val database = Room.databaseBuilder(
        context,
        Database::class.java,
        "orders_database"
    ).build()

    override suspend fun addOrder(order: Order) {
        database.orderDao().insertOrder(
            OrderEntity(
                pizzaName = order.pizzaName,
                price = order.price,
                extraCheese = order.extraCheese
            )
        )
    }

    override suspend fun getAllOrders(): List<Order> {
        return database.orderDao().getAllOrders().map { entity ->
            Order(
                id = entity.id,
                pizzaName = entity.pizzaName,
                price = entity.price,
                extraCheese = entity.extraCheese
            )
        }
    }
}