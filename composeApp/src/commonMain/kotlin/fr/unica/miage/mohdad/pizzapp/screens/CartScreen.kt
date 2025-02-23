package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.composables.TopBar
import fr.unica.miage.mohdad.pizzapp.model.Order
import fr.unica.miage.mohdad.pizzapp.viewmodel.CartViewModel
import fr.unica.miage.mohdad.pizzapp.viewmodel.OrderHistoryViewModel
import kotlinx.coroutines.launch

@Composable
fun CartScreen(
    onNavigateBack: () -> Unit,
    cartViewModel: CartViewModel,
    orderHistoryViewModel: OrderHistoryViewModel
) {
    var showConfirmDialog by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopBar(
                title = "Votre panier",
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
            if (cartViewModel.cartItems.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Votre panier est vide",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            } else {
                LazyColumn(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(cartViewModel.cartItems) { item ->
                        Card(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(16.dp)
                            ) {
                                Text(
                                    text = item.pizza.name,
                                    style = MaterialTheme.typography.titleMedium
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "Extra fromage: ${item.extraCheese}g",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                                Text(
                                    text = "${item.pizza.price}€",
                                    style = MaterialTheme.typography.titleMedium,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Total:",
                                style = MaterialTheme.typography.titleLarge
                            )
                            Text(
                                text = "${cartViewModel.getTotalPrice()}€",
                                style = MaterialTheme.typography.titleLarge,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                        Button(
                            onClick = { showConfirmDialog = true },
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text("Valider la commande")
                        }
                    }
                }
            }
        }

        if (showConfirmDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                title = { Text("Confirmation") },
                text = { Text("Voulez-vous valider votre commande ?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            cartViewModel.cartItems.forEach { item ->
                                scope.launch {
                                    orderHistoryViewModel.addOrder(
                                        Order(
                                            pizzaName = item.pizza.name,
                                            price = item.pizza.price,
                                            extraCheese = item.extraCheese
                                        )
                                    )
                                }
                            }
                            cartViewModel.clearCart()
                            showConfirmDialog = false
                        }
                    ) {
                        Text("Oui")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showConfirmDialog = false }) {
                        Text("Non")
                    }
                }
            )
        }
    }
}