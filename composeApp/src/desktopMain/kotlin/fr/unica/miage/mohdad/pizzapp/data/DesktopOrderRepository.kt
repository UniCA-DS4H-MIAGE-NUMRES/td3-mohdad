package fr.unica.miage.mohdad.pizzapp.data

// composeApp/src/desktopMain/kotlin/fr/unica/miage/mohdad/pizzapp/data/DesktopOrderRepository.k

import fr.unica.miage.mohdad.pizzapp.model.Order
import org.sqlite.SQLiteDataSource
import java.sql.Connection

class DesktopOrderRepository : OrderRepository {
    private val connection: Connection

    init {
        val dataSource = SQLiteDataSource()
        dataSource.url = "jdbc:sqlite:pizzapp.db"
        connection = dataSource.connection

        connection.createStatement().execute("""
            CREATE TABLE IF NOT EXISTS orders (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                pizzaName TEXT NOT NULL,
                price REAL NOT NULL,
                extraCheese INTEGER NOT NULL
            )
        """)
    }

    override suspend fun addOrder(order: Order) {
        val stmt = connection.prepareStatement(
            "INSERT INTO orders (pizzaName, price, extraCheese) VALUES (?, ?, ?)"
        )
        stmt.setString(1, order.pizzaName)
        stmt.setDouble(2, order.price)
        stmt.setInt(3, order.extraCheese)
        stmt.executeUpdate()
    }

    override suspend fun getAllOrders(): List<Order> {
        val orders = mutableListOf<Order>()
        val stmt = connection.createStatement()
        val rs = stmt.executeQuery("SELECT * FROM orders")

        while (rs.next()) {
            orders.add(Order(
                id = rs.getInt("id"),
                pizzaName = rs.getString("pizzaName"),
                price = rs.getDouble("price"),
                extraCheese = rs.getInt("extraCheese")
            ))
        }
        return orders
    }

    override suspend fun clearAllOrders() {
        connection.createStatement().execute("DELETE FROM orders")
    }
}