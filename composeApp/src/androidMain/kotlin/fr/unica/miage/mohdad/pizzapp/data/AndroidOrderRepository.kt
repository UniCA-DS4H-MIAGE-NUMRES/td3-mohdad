package fr.unica.miage.mohdad.pizzapp.data

import android.content.Context
import androidx.room.Room
import fr.unica.miage.mohdad.pizzapp.model.Order
import fr.unica.miage.mohdad.pizzapp.model.OrderEntity

class AndroidOrderRepository(context: Context) : OrderRepository {
    private val database = Room.databaseBuilder(
        context,
        AppDatabase::class.java,
        "orders_database"
    )
        .fallbackToDestructiveMigration() // Optionnel: permet de recréer la base si la version change
        .build()

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