package crystalrockcoffee.store.app.data.repository

import crystalrockcoffee.store.app.R
import crystalrockcoffee.store.app.data.model.Product
import crystalrockcoffee.store.app.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products: List<Product> = listOf(
        Product(
            id = 1,
            title = "Colombian Supremo",
            description = "Rich, full-bodied single-origin coffee with notes of caramel and dark chocolate. Sourced from the highlands of Huila, Colombia.",
            price = 12.99,
            imageRes = R.drawable.product_colombian,
            category = ProductCategory.COFFEE_BEANS,
        ),
        Product(
            id = 2,
            title = "Ethiopian Yirgacheffe",
            description = "Bright and floral with citrus undertones. A light roast that captures the essence of Ethiopian highland terroir.",
            price = 14.99,
            imageRes = R.drawable.product_ethiopian,
            category = ProductCategory.COFFEE_BEANS,
        ),
        Product(
            id = 3,
            title = "Sumatra Mandheling",
            description = "Deep, earthy flavour with low acidity. Dark roasted for a bold, smooth finish.",
            price = 13.49,
            imageRes = R.drawable.product_sumatra,
            category = ProductCategory.COFFEE_BEANS,
        ),
        Product(
            id = 4,
            title = "Classic Espresso",
            description = "Our signature double-shot espresso blend. Strong, aromatic, and perfectly balanced with a rich crema.",
            price = 3.50,
            imageRes = R.drawable.product_espresso,
            category = ProductCategory.BEVERAGES,
        ),
        Product(
            id = 5,
            title = "Caramel Latte",
            description = "Silky steamed milk combined with our espresso and house-made caramel syrup.",
            price = 4.75,
            imageRes = R.drawable.product_latte,
            category = ProductCategory.BEVERAGES,
        ),
        Product(
            id = 6,
            title = "Macchiato",
            description = "Bold espresso marked with a dollop of velvety foam. Simple, elegant, and intensely flavourful.",
            price = 3.99,
            imageRes = R.drawable.product_macchiato,
            category = ProductCategory.BEVERAGES,
        ),
        Product(
            id = 7,
            title = "Butter Croissant",
            description = "Flaky, golden layers of hand-rolled pastry made with premium European butter. Baked fresh every morning.",
            price = 3.25,
            imageRes = R.drawable.product_croissant,
            category = ProductCategory.PASTRIES,
        ),
        Product(
            id = 8,
            title = "Danish Pastry",
            description = "Light puff pastry filled with vanilla custard and topped with seasonal fruit glaze.",
            price = 3.75,
            imageRes = R.drawable.product_danish,
            category = ProductCategory.PASTRIES,
        ),
        Product(
            id = 9,
            title = "Chocolate Fondant",
            description = "Warm, indulgent chocolate cake with a molten centre. Served with a dusting of cocoa powder.",
            price = 6.50,
            imageRes = R.drawable.product_fondant,
            category = ProductCategory.DESSERTS,
        ),
        Product(
            id = 10,
            title = "Tiramisu",
            description = "Classic Italian layered dessert with mascarpone cream, espresso-soaked ladyfingers, and cocoa.",
            price = 7.25,
            imageRes = R.drawable.product_tiramisu,
            category = ProductCategory.DESSERTS,
        ),
        Product(
            id = 11,
            title = "Affogato",
            description = "A scoop of artisan vanilla gelato drowned in a fresh shot of hot espresso.",
            price = 5.50,
            imageRes = R.drawable.product_espresso,
            category = ProductCategory.DESSERTS,
        ),
        Product(
            id = 12,
            title = "Cold Brew",
            description = "Slow-steeped for 18 hours using our custom blend. Smooth, refreshing, and naturally sweet.",
            price = 4.25,
            imageRes = R.drawable.product_latte,
            category = ProductCategory.BEVERAGES,
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
