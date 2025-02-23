package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.composables.TopBar
import fr.unica.miage.mohdad.pizzapp.model.Pizza
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.PizzaViewModel
import org.jetbrains.compose.resources.painterResource


@Composable
fun PizzaScreen(
    pizzaId: Int,
    onNavigateBack: () -> Unit,
    cartViewModel: CartViewModel,
    pizzaViewModel: PizzaViewModel
) {
    val pizza = pizzaViewModel.pizzas.first { it.id == pizzaId }

    Scaffold(
        topBar = {
            TopBar(
                title = "Détails Pizza",
                onNavigateBack = onNavigateBack
            )
        }
    ) { padding ->
        DetailPizza(
            pizza = pizza,
            cartViewModel = cartViewModel,
            modifier = Modifier.padding(padding),
            onAddToCart = { pizza, extraCheese ->
                cartViewModel.addToCart(pizza, extraCheese)
                onNavigateBack()
            }
        )
    }
}

@Composable
private fun DetailPizza(
    pizza: Pizza,
    modifier: Modifier = Modifier,
    cartViewModel: CartViewModel,
    onAddToCart: (Pizza, Int) -> Unit
) {
    var extraCheese by remember { mutableStateOf(50) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddToCart(pizza, extraCheese) },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Ajouter au panier"
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                ),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(pizza.imageResource),
                        contentDescription = pizza.name,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(250.dp)
                            .clip(MaterialTheme.shapes.medium)
                    )

                    Text(
                        text = pizza.name,
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(top = 8.dp)
                    )

                    Text(text = pizza.name, style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Prix: ${pizza.price} €", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Extra Fromage: ${extraCheese}g", style = MaterialTheme.typography.bodyMedium)

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Text(
                            text = "Extra Fromage : $extraCheese%",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Slider(
                            value = extraCheese.toFloat(),
                            onValueChange = { extraCheese = it.toInt() },
                            valueRange = 0f..100f,
                            steps = 4,
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colorScheme.primary,
                                activeTrackColor = MaterialTheme.colorScheme.primary,
                                inactiveTrackColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                            )
                        )
                    }

                    Text(
                        text = "Prix total : ${(kotlin.math.round(pizza.price * (1 + extraCheese / 100.0) * 100) / 100)}€",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
        }
    }
}