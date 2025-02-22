package fr.unica.miage.mohdad.pizzapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter

@Composable
actual fun loadImage(resourcePath: String): Painter {
    return EmptyPainter // Retourne un Painter qui ne dessine rien
}

// Définition d'un Painter vide
object EmptyPainter : Painter() {
    override val intrinsicSize = androidx.compose.ui.geometry.Size.Zero

    override fun DrawScope.onDraw() {
        // Ne dessine rien
    }
}
