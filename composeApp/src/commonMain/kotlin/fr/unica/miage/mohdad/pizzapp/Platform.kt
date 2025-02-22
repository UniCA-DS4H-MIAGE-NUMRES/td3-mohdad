package fr.unica.miage.mohdad.pizzapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform