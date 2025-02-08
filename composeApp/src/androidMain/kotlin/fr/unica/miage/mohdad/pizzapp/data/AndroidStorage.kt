package fr.unica.miage.mohdad.pizzapp.data

import fr.unica.miage.mohdad.pizzapp.multiplatform.model.OrderEntity
import kotlinx.coroutines.flow.Flow

class AndroidStorage(private val orderDao: OrderDao) : Storage {
    override fun getAllOrders(): Flow<List<OrderEntity>> = orderDao.getAllOrders()
    override suspend fun insertOrder(order: OrderEntity) = orderDao.insertOrder(order)
    override suspend fun clearOrders() = orderDao.clearOrders()
}
