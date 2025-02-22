package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.composables.PizzaCard
import fr.unica.miage.mohdad.pizzapp.composables.TopBar
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel

@Composable
fun MenuScreen(
    onNavigateBack: () -> Unit,
    onPizzaClick: (Int) -> Unit,
    pizzaViewModel: PizzaViewModel
) {
    Scaffold(
        topBar = {
            TopBar(
                title = "Pizza Menu",
                onNavigateBack = onNavigateBack
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            LazyColumn {
                items(pizzaViewModel.pizzas) { pizza ->
                    PizzaCard(
                        pizza = pizza,
                        onClick = { onPizzaClick(pizza.id) }
                    )
                }
            }
        }
    }
}
