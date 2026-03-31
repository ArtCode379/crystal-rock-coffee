package crystalrockcoffee.store.app.di

import crystalrockcoffee.store.app.data.datastore.RSRKCOnboardingPrefs
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataStoreModule = module {
    single { RSRKCOnboardingPrefs(androidContext()) }
}