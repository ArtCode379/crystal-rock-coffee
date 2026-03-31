package crystalrockcoffee.store.app.di

import crystalrockcoffee.store.app.data.repository.CartRepository
import crystalrockcoffee.store.app.data.repository.RSRKCOnboardingRepo
import crystalrockcoffee.store.app.data.repository.OrderRepository
import crystalrockcoffee.store.app.data.repository.ProductRepository

import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    includes(databaseModule, dataStoreModule)

    single {
        RSRKCOnboardingRepo(
            rsrkcOnboardingStoreManager = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single { ProductRepository() }

    single {
        CartRepository(
            cartItemDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }

    single {
        OrderRepository(
            orderDao = get(),
            coroutineDispatcher = get(named("IO"))
        )
    }
}