package fr.unica.miage.mohdad.pizzapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun loadImage(resourcePath: String): Painter