package fr.unica.miage.mohdad.pizzapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.ui.components.CartView
import fr.unica.miage.mohdad.pizzapp.ui.components.PizzaCard
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaListScreen(
    pizzaViewModel: PizzaViewModel,
    cartViewModel: CartViewModel
) {
    var showCart by remember { mutableStateOf(false) }
    val pizzas by pizzaViewModel.pizzas
    val loading by pizzaViewModel.loading
    val error by pizzaViewModel.error
    val cartItems by cartViewModel.items

    LaunchedEffect(Unit) {
        pizzaViewModel.loadPizzas()
    }

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text("PizzApp") },
            actions = {
                Button(
                    onClick = { showCart = true },
                    modifier = Modifier.padding(end = 16.dp)
                ) {
                    if (cartItems.isNotEmpty()) {
                        Text("Panier (${cartItems.sumOf { it.quantity }})") 
                    } else {
                        Text("Panier")
                    }
                }
            }
        )

        Box(modifier = Modifier.fillMaxSize()) {
            when {
                loading -> CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
                error != null -> Text(
                    text = error ?: "Une erreur est survenue",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
                else -> LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 300.dp),
                    contentPadding = PaddingValues(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(pizzas) { pizza ->
                        PizzaCard(
                            pizza = pizza,
                            onAddToCart = { cartViewModel.addPizza(pizza) }
                        )
                    }
                }
            }

            if (showCart) {
                CartView(
                    cartViewModel = cartViewModel,
                    onClose = { showCart = false }
                )
            }
        }
    }
}