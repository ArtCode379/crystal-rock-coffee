package crystalrockcoffee.store.app.di

import crystalrockcoffee.store.app.ui.viewmodel.AppViewModel
import crystalrockcoffee.store.app.ui.viewmodel.CartViewModel
import crystalrockcoffee.store.app.ui.viewmodel.CheckoutViewModel
import crystalrockcoffee.store.app.ui.viewmodel.RSRKCOnboardingVM
import crystalrockcoffee.store.app.ui.viewmodel.OrderViewModel
import crystalrockcoffee.store.app.ui.viewmodel.ProductDetailsViewModel
import crystalrockcoffee.store.app.ui.viewmodel.ProductViewModel
import crystalrockcoffee.store.app.ui.viewmodel.RSRKCSplashVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModule = module {
    viewModel {
        AppViewModel(
            cartRepository = get()
        )
    }

    viewModel {
        RSRKCSplashVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        RSRKCOnboardingVM(
            onboardingRepository = get()
        )
    }

    viewModel {
        ProductViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        ProductDetailsViewModel(
            productRepository = get(),
            cartRepository = get(),
        )
    }

    viewModel {
        CheckoutViewModel(
            cartRepository = get(),
            productRepository = get(),
            orderRepository = get(),
        )
    }

    viewModel {
        CartViewModel(
            cartRepository = get(),
            productRepository = get(),
        )
    }

    viewModel {
        OrderViewModel(
            orderRepository = get(),
        )
    }
}