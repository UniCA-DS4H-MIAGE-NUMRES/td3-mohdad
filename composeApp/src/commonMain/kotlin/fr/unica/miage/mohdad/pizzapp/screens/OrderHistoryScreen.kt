
package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.AlertDialog
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.viewmodel.OrderHistoryViewModel
import kotlinx.coroutines.launch

@Composable
fun OrderHistoryScreen(
    onNavigateBack: () -> Unit,
    viewModel: OrderHistoryViewModel
) {
    val scope = rememberCoroutineScope()
    var showConfirmDialog by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        viewModel.loadOrders()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Historique des commandes") },
                actions = {
                    if (viewModel.orders.isNotEmpty()) {
                        IconButton(onClick = { showConfirmDialog = true }) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Effacer l'historique"
                            )
                        }
                    }
                }
            )
        }
    ) { padding ->
        if (viewModel.orders.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Text("Aucune commande dans l'historique")
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(viewModel.orders) { order ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = order.pizzaName,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Prix: ${order.price} €",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            if (order.extraCheese > 0) {
                                Text(
                                    text = "Extra fromage: ${order.extraCheese}g",
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }
                    }
                }
            }
        }

        if (showConfirmDialog) {
            AlertDialog(
                onDismissRequest = { showConfirmDialog = false },
                title = { Text("Confirmation") },
                text = { Text("Voulez-vous effacer tout l'historique ?") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            // Call the clearHistory method from viewModel
                            scope.launch {
                                viewModel.clearHistory()
                            }
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