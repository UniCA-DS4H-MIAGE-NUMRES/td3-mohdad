package fr.unica.miage.mohdad.pizzapp.data


actual fun getOrderRepository(): OrderRepository {
    return WasmOrderRepository()
}