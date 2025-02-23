package fr.unica.miage.mohdad.pizzapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.unica.miage.mohdad.pizzapp.model.OrderEntity

@Dao
interface OrderDao {
    @Insert
    suspend fun insertOrder(order: OrderEntity)

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<OrderEntity>

    @Query("DELETE FROM orders")
    suspend fun deleteAllOrders()
}