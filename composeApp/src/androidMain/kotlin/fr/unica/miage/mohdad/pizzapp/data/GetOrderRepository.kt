// androidMain
package fr.unica.miage.mohdad.pizzapp.data

import android.content.Context

lateinit var appContext: Context

actual fun getOrderRepository(): OrderRepository {
    return AndroidOrderRepository(appContext)
}