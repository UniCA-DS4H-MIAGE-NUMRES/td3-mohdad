package fr.unica.miage.mohdad.pizzapp.viewmodel

import fr.unica.miage.mohdad.pizzapp.model.Pizza
import td3_mohdad.composeapp.generated.resources.Res
import td3_mohdad.composeapp.generated.resources.pizza1
import td3_mohdad.composeapp.generated.resources.pizza2
import td3_mohdad.composeapp.generated.resources.pizza3
import td3_mohdad.composeapp.generated.resources.pizza4
import td3_mohdad.composeapp.generated.resources.pizza5
import td3_mohdad.composeapp.generated.resources.pizza6
import td3_mohdad.composeapp.generated.resources.pizza7
import td3_mohdad.composeapp.generated.resources.pizza8
import td3_mohdad.composeapp.generated.resources.pizza9

class PizzaViewModel{
    val pizzas = listOf(
        Pizza(1,
            "Margherita",
            Res.drawable.pizza1,
            8.50,
            listOf("Tomato", "Cheese")
        ),
        Pizza(2,
            "Pepperoni",
            Res.drawable.pizza2,
            10.00,
            listOf("Pepperoni", "Cheese")
        ),
        Pizza(3,
            "Hawaiian",
            Res.drawable.pizza3,
            9.00,
            listOf("Ham", "Pineapple", "Cheese")
        ),
        Pizza(4,
            "BBQ Chicken",
            Res.drawable.pizza4,
            11.00,
            listOf("Chicken", "BBQ Sauce", "Cheese")
        ),
        Pizza(5,
            "Veggie",
            Res.drawable.pizza5,
            8.00,
            listOf("Bell Peppers", "Onions", "Mushrooms", "Cheese")
        ),
        Pizza(6,
            "Four Cheese",
            Res.drawable.pizza6,
            9.50,
            listOf("Mozzarella", "Cheddar", "Parmesan", "Gorgonzola")
        ),
        Pizza(7,
            "Meat Lovers",
            Res.drawable.pizza7,
            12.00,
            listOf("Pepperoni", "Sausage", "Bacon", "Ham", "Cheese")
        ),
        Pizza(8,
            "Buffalo Chicken",
            Res.drawable.pizza8,
            11.50,
            listOf("Chicken", "Buffalo Sauce", "Cheese")
        ),
        Pizza(9,
            "Mushroom",
            Res.drawable.pizza9,
            8.75,
            listOf("Mushrooms", "Garlic", "Cheese")
        )
    )
}
