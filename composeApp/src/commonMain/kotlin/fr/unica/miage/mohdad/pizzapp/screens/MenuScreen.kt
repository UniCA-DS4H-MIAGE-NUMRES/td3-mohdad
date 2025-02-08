@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaMenu(
    navController: NavController,
    pizzaViewModel: PizzaViewModel,
    modifier: Modifier = Modifier
) {
    val pizzas by pizzaViewModel.pizzas.collectAsState()

    AppScaffold(
        topBar = {
            LargeTopAppBar(
                title = {
                    Text(
                        "Notre Carte",
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                )
            )
        },
        modifier = modifier
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 300.dp),
            contentPadding = PaddingValues(
                horizontal = Dimensions.paddingMedium,
                vertical = Dimensions.paddingMedium
            ),
            horizontalArrangement = Arrangement.spacedBy(Dimensions.spacingMedium),
            verticalArrangement = Arrangement.spacedBy(Dimensions.spacingMedium),
            modifier = Modifier.fillMaxSize()
        ) {
            items(pizzas) { pizza ->
                PizzaCard(
                    pizza = pizza,
                    onClickPizza = {
                        navController.navigate(PizzaRoute(pizzas.indexOf(pizza)))
                    }
                )
            }
        }
    }
}
