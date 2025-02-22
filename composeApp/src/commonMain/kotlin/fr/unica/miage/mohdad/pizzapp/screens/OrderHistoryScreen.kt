package fr.unica.miage.mohdad.pizzapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.composables.TopBar
import fr.unica.miage.mohdad.pizzapp.viewmodel.OrderHistoryViewModel

@Composable
fun OrderHistoryScreen(
    onNavigateBack: () -> Unit,
    viewModel: OrderHistoryViewModel
) {
    LaunchedEffect(Unit) {
        viewModel.loadOrders()
    }

    Scaffold(
        topBar = {
            TopBar(
                title = "Historique des commandes",
                onNavigateBack = onNavigateBack
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
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
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = "Prix: ${order.price} €",
                            style = MaterialTheme.typography.body1
                        )
                        if (order.extraCheese > 0) {
                            Text(
                                text = "Extra fromage: ${order.extraCheese}g",
                                style = MaterialTheme.typography.body2
                            )
                        }
                    }
                }
            }
        }
    }
}