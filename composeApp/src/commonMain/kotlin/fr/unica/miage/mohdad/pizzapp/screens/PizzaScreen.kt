package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Slider
import androidx.compose.material.SliderDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.composables.TopBar
import fr.unica.miage.mohdad.pizzapp.utils.loadImage
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel

@Composable
fun PizzaScreen(
    pizzaId: Int,
    onNavigateBack: () -> Unit,
    cartViewModel: CartViewModel,
    pizzaViewModel: PizzaViewModel
) {
    val pizza = pizzaViewModel.pizzas.first { it.id == pizzaId }
    var extraCheese by remember { mutableStateOf(0f) }

    Scaffold(
        topBar = {
            TopBar(
                title = "Pizza Menu",
                onNavigateBack = onNavigateBack
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    cartViewModel.addToCart(pizza, extraCheese.toInt())
                }
            ) {
                Text("+")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Image placeholder
            Image(
                painter = loadImage("pizza${pizza.id}.png"),
                contentDescription = pizza.name,
                modifier = Modifier
                    .size(200.dp)
                    .fillMaxWidth()
            )

            Text(text = pizza.name, style = MaterialTheme.typography.h5)
            Text(text = "Prix: ${pizza.price} €", style = MaterialTheme.typography.body1)
            Text(text = "Extra Fromage: ${extraCheese.toInt()}g", style = MaterialTheme.typography.body1)

            Slider(
                value = extraCheese,
                onValueChange = { extraCheese = it },
                valueRange = 0f..100f,
                colors = SliderDefaults.colors(
                    thumbColor = MaterialTheme.colors.secondary,
                    activeTrackColor = MaterialTheme.colors.secondary,
                    inactiveTrackColor = MaterialTheme.colors.secondary.copy(alpha = 0.3f)
                ),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}
