package fr.unica.miage.mohdad.pizzapp.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import td3_mohdad.composeapp.generated.resources.Res
import td3_mohdad.composeapp.generated.resources.logo





@Composable
fun WelcomeScreen(onNavigateToMenu: () -> Unit, onNavigateToCart: () -> Unit, onNavigateToHistory: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = onNavigateToMenu,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Voir le menu")
        }

        Button(
            onClick = onNavigateToCart,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Voir le panier")
        }

        Button(
            onClick = onNavigateToHistory,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)
        ) {
            Text("Historique des commandes")
        }
    }
}
