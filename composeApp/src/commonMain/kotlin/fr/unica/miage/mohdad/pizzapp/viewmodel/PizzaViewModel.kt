package fr.unica.miage.mohdad.pizzapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key.Companion.R
import fr.unica.miage.mohdad.pizzapp.model.Pizza

class PizzaViewModel {
    val pizzas = mutableStateOf<List<Pizza>>(emptyList())
    val loading = mutableStateOf(false)
    val error = mutableStateOf<String?>(null)
    
    fun loadPizzas() {
        loading.value = true
        error.value = null
        
        // Simulated data loading
        pizzas.value = listOf(
            Pizza(
                id = 1,
                name = "Margherita",
                description = "Fresh tomatoes, mozzarella, basil",
                price = 8.0,
                imageUrl = "pizza1.png"
            ),
            Pizza(
                id = 2,
                name = "Capricciosa",
                description = "Ham, mushrooms, artichokes, olives",
                price = 10.0,
                imageUrl = "pizza2.png"
            ),
            Pizza(
                id = 3,
                name = "Diavola",
                description = "Spicy salami, chili peppers",
                price = 9.0,
                imageUrl = "pizza3.png"
            ),
            Pizza(
                id = 4,
                name = "Quattro Stagioni",
                description = "Four sections: mushrooms, ham, vegetables, olives",
                price = 11.0,
                imageUrl = "pizza4.png"
            ),
            Pizza(
                id = 5,
                name = "Quattro Formaggi",
                description = "Four cheeses: mozzarella, gorgonzola, parmesan, fontina",
                price = 12.0,
                imageUrl = "pizza5.png"
            ),
            Pizza(
                id = 6,
                name = "Marinara",
                description = "Tomatoes, garlic, oregano",
                price = 7.0,
                imageUrl = "pizza6.png"
            ),
            Pizza(
                id = 7,
                name = "Pepperoni",
                description = "Pepperoni, mozzarella",
                price = 9.0,
                imageUrl = "pizza7.png"
            ),
            Pizza(
                id = 8,
                name = "Prosciutto",
                description = "Prosciutto ham, mozzarella, rocket",
                price = 10.0,
                imageUrl = "pizza8.png"
            ),
            Pizza(
                id = 9,
                name = "Frutti di Mare",
                description = "Mixed seafood, garlic",
                price = 13.0,
                imageUrl = "pizza9.png"
            )
        )
        
        loading.value = false
    }
}