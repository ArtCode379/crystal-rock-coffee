package crystalrockcoffee.store.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import crystalrockcoffee.store.app.data.dao.CartItemDao
import crystalrockcoffee.store.app.data.dao.OrderDao
import crystalrockcoffee.store.app.data.database.converter.Converters
import crystalrockcoffee.store.app.data.entity.CartItemEntity
import crystalrockcoffee.store.app.data.entity.OrderEntity

@Database(
    entities = [CartItemEntity::class, OrderEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class RSRKCDatabase : RoomDatabase() {

    abstract fun cartItemDao(): CartItemDao

    abstract fun orderDao(): OrderDao
}