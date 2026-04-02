package crystalrockcoffee.store.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
    primary = GoldDark,
    secondary = DarkNavyDark,
    background = BackgroundDark,
    surface = SurfaceDark,
    onPrimary = OnPrimaryDark,
    onSecondary = OnSurfaceDark,
    onBackground = OnSurfaceDark,
    onSurface = OnSurfaceDark,
    error = ErrorRed,
)

private val LightColorScheme = lightColorScheme(
    primary = Gold,
    secondary = DarkNavy,
    background = Background,
    surface = Surface,
    onPrimary = OnPrimary,
    onSecondary = OnSurface,
    onBackground = OnSurface,
    onSurface = OnSurface,
    error = ErrorRed,
)

@Composable
fun ProductAppRSRKCTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
