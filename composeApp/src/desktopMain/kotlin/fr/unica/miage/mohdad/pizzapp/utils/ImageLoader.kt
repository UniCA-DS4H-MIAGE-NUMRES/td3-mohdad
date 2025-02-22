package fr.unica.miage.mohdad.pizzapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi

@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun loadImage(resourcePath: String): Painter {
    val resource = when(resourcePath) {
        "logo.png" -> "drawable/logo.png"
        "pizza1.png" -> "drawable/pizza1.png"
        "pizza2.png" -> "drawable/pizza2.png"
        "pizza3.png" -> "drawable/pizza3.png"
        "pizza4.png" -> "drawable/pizza4.png"
        "pizza5.png" -> "drawable/pizza5.png"
        "pizza6.png" -> "drawable/pizza6.png"
        "pizza7.png" -> "drawable/pizza7.png"
        "pizza8.png" -> "drawable/pizza8.png"
        "pizza9.png" -> "drawable/pizza9.png"
        else -> throw IllegalStateException("Image introuvable")
    }
    return painterResource(resource)
}