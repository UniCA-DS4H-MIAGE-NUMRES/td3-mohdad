package fr.unica.miage.mohdad.pizzapp.model

data class Order(
    val id: Int = 0,
    val pizzaName: String,
    val price: Double,
    val extraCheese: Int
)