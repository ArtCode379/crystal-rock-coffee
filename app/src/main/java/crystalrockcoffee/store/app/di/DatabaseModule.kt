package crystalrockcoffee.store.app.di

import androidx.room.Room
import crystalrockcoffee.store.app.data.database.RSRKCDatabase
import org.koin.dsl.module

private const val DB_NAME = "rsrkc_db"

val databaseModule = module {
    single {
        Room.databaseBuilder(
            context = get(),
            klass = RSRKCDatabase::class.java,
            name = DB_NAME
        ).build()
    }

    single { get<RSRKCDatabase>().cartItemDao() }

    single { get<RSRKCDatabase>().orderDao() }
}