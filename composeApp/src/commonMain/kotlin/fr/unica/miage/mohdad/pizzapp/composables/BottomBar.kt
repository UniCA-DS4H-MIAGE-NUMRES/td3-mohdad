package fr.unica.miage.mohdad.pizzapp.composables

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable

import fr.unica.miage.mohdad.pizzapp.navigation.Screen

@Composable
fun BottomBar(
    currentScreen: Screen,
    onNavigate: (Screen) -> Unit
) {
    BottomNavigation {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Accueil") },
            label = { Text("Accueil") },
            selected = currentScreen is Screen.Welcome,
            onClick = { onNavigate(Screen.Welcome) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Menu, contentDescription = "Menu") },
            label = { Text("Menu") },
            selected = currentScreen is Screen.Menu,
            onClick = { onNavigate(Screen.Menu) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Panier") },
            label = { Text("Panier") },
            selected = currentScreen is Screen.Cart,
            onClick = { onNavigate(Screen.Cart) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "Historique") },
            label = { Text("Historique") },
            selected = currentScreen is Screen.OrderHistory,
            onClick = { onNavigate(Screen.OrderHistory) }
        )
    }
}