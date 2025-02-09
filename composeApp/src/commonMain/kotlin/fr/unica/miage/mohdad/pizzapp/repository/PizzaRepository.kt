package fr.unica.miage.mohdad.pizzapp.repository

import fr.unica.miage.mohdad.pizzapp.model.Pizza

class PizzaRepository {
    // Simulated data for now
    fun getAllPizzas(): List<Pizza> = listOf(
        Pizza(1, "Margherita", "Tomate, Mozzarella, Basilic", 10.0),
        Pizza(2, "Regina", "Tomate, Mozzarella, Jambon, Champignons", 12.0),
        Pizza(3, "Quatre Fromages", "Tomate, Mozzarella, Gorgonzola, Parmesan, Chèvre", 13.0)
    )
}