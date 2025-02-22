package fr.unica.miage.mohdad.pizzapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import fr.unica.miage.mohdad.pizzapp.model.OrderEntity

@Database(entities = [OrderEntity::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun orderDao(): OrderDao
}