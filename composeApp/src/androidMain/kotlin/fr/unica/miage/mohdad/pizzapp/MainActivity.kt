package fr.unica.miage.mohdad.pizzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import fr.unica.miage.mohdad.pizzapp.data.appContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appContext = applicationContext // Initialisation du contexte Android
        setContent {
            App()
        }
    }
}