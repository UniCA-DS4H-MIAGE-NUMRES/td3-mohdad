


// App.kt
package fr.unica.miage.mohdad.pizzapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import fr.unica.miage.mohdad.pizzapp.composables.BottomBar
import fr.unica.miage.mohdad.pizzapp.data.getOrderRepository
import fr.unica.miage.mohdad.pizzapp.navigation.Screen
import fr.unica.miage.mohdad.pizzapp.screens.CartScreen
import fr.unica.miage.mohdad.pizzapp.screens.MenuScreen
import fr.unica.miage.mohdad.pizzapp.screens.OrderHistoryScreen
import fr.unica.miage.mohdad.pizzapp.screens.PizzaScreen
import fr.unica.miage.mohdad.pizzapp.screens.WelcomeScreen
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.OrderHistoryViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel

@Composable
fun App() {
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Welcome) }
    val cartViewModel = remember { CartViewModel() }
    val pizzaViewModel = remember { PizzaViewModel() }
    val orderHistoryViewModel = remember {
        OrderHistoryViewModel(getOrderRepository()) // Utilise la bonne implémentation
    }

    Scaffold(
        bottomBar = {
            BottomBar(
                currentScreen = currentScreen,
                onNavigate = { screen ->
                    if (screen !is Screen.Pizza) {
                        currentScreen = screen
                    }
                }
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (val screen = currentScreen) {
                is Screen.Welcome -> WelcomeScreen(
                    onNavigateToMenu = { currentScreen = Screen.Menu },
                    onNavigateToCart = { currentScreen = Screen.Cart },
                    onNavigateToHistory = { currentScreen = Screen.OrderHistory }
                )

                is Screen.Menu -> MenuScreen(
                    onNavigateBack = { currentScreen = Screen.Welcome },
                    onPizzaClick = { pizzaId -> currentScreen = Screen.Pizza(pizzaId) },
                    pizzaViewModel = pizzaViewModel
                )

                is Screen.Pizza -> PizzaScreen(
                    pizzaId = screen.pizzaId,
                    onNavigateBack = { currentScreen = Screen.Menu },
                    cartViewModel = cartViewModel,
                    pizzaViewModel = pizzaViewModel
                )

                is Screen.Cart -> CartScreen(
                    onNavigateBack = { currentScreen = Screen.Menu },
                    cartViewModel = cartViewModel,
                    orderHistoryViewModel = orderHistoryViewModel
                )

                is Screen.OrderHistory -> OrderHistoryScreen(
                    onNavigateBack = { currentScreen = Screen.Menu },
                    viewModel = orderHistoryViewModel
                )
            }
        }
    }
}