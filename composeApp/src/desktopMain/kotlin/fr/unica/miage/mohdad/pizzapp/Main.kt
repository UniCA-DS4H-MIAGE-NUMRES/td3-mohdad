package fr.unica.miage.mohdad.pizzapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "PizzApp") {
        App()
    }
}