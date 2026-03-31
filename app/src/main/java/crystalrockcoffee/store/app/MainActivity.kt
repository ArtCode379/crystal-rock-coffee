package crystalrockcoffee.store.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import crystalrockcoffee.store.app.ui.composable.approot.AppRoot
import crystalrockcoffee.store.app.ui.theme.ProductAppRSRKCTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProductAppRSRKCTheme {
                AppRoot()
            }
        }
    }
}