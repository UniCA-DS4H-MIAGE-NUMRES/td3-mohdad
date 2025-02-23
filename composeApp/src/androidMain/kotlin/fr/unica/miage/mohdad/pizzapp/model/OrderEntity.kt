package fr.unica.miage.mohdad.pizzapp.model

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val pizzaName: String,
    val price: Double,
    val extraCheese: Int
)

@Dao
interface OrderDao {
    @Insert
    suspend fun insertOrder(order: OrderEntity)

    @Query("SELECT * FROM orders")
    suspend fun getAllOrders(): List<OrderEntity>
}

@Database(entities = [OrderEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}