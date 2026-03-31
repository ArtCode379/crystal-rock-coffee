package crystalrockcoffee.store.app

import android.app.Application
import crystalrockcoffee.store.app.di.dataModule
import crystalrockcoffee.store.app.di.dispatcherModule
import crystalrockcoffee.store.app.di.viewModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class RSRKCApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val appModules = dataModule + viewModule + dispatcherModule

        startKoin {
            androidLogger()
            androidContext(this@RSRKCApp)
            modules(appModules)
        }
    }
}