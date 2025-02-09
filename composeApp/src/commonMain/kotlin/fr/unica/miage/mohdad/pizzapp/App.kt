package fr.unica.miage.mohdad.pizzapp


import androidx.compose.runtime.*
import androidx.compose.material3.*
import fr.unica.miage.mohdad.pizzapp.ui.screens.PizzaListScreen
import fr.unica.miage.mohdad.pizzapp.ui.theme.PizzaAppTheme
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel

@Composable
fun App() {
    val pizzaViewModel = remember { PizzaViewModel() }
    val cartViewModel = remember { CartViewModel() }
    
    PizzaAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            PizzaListScreen(
                pizzaViewModel = pizzaViewModel,
                cartViewModel = cartViewModel
            )
        }
    }
}
