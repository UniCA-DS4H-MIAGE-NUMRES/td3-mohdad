package fr.unica.miage.mohdad.pizzapp.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import fr.unica.miage.mohdad.pizzapp.model.Pizza
import org.jetbrains.compose.resources.InternalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterialApi::class, InternalResourceApi::class)
@Composable
fun PizzaCard(pizza: Pizza, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        onClick = onClick
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Image(
                //painter = loadImage("pizza${pizza.id}.png"),
                painter = painterResource(pizza.imageResource),
                contentDescription = pizza.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = pizza.name, style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "${pizza.price} €", style = MaterialTheme.typography.body1)
            }
        }
    }
}

