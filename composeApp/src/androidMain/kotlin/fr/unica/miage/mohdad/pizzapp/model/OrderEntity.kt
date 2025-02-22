package fr.unica.miage.mohdad.pizzapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "orders")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val pizzaName: String,
    val price: Double,
    val extraCheese: Int
)