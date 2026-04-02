package crystalrockcoffee.store.app.data.model

import androidx.annotation.StringRes
import crystalrockcoffee.store.app.R

enum class ProductCategory(@field:StringRes val titleRes: Int) {
    COFFEE_BEANS(R.string.category_coffee_beans),
    BEVERAGES(R.string.category_beverages),
    PASTRIES(R.string.category_pastries),
    DESSERTS(R.string.category_desserts),
}
