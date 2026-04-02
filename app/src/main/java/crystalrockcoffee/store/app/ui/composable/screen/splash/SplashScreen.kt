package crystalrockcoffee.store.app.ui.composable.screen.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import crystalrockcoffee.store.app.R
import crystalrockcoffee.store.app.ui.viewmodel.RSRKCSplashVM
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
    viewModel: RSRKCSplashVM = koinViewModel(),
    onNavigateToHomeScreen: () -> Unit,
    onNavigateToOnboarding: () -> Unit,
) {
    val onboardedState by viewModel.onboardedState.collectAsStateWithLifecycle()

    val iconAlpha = remember { Animatable(0f) }
    val iconScale = remember { Animatable(0.8f) }
    val textAlpha = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        iconAlpha.animateTo(1f, animationSpec = tween(800))
        iconScale.animateTo(1f, animationSpec = tween(800))
        delay(200)
        textAlpha.animateTo(1f, animationSpec = tween(400))
        delay(500)
        if (onboardedState) {
            onNavigateToHomeScreen()
        } else {
            onNavigateToOnboarding()
        }
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(0xFF1A1A1A), Color(0xFF2C3E50))
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = "Crystal Rock Coffee logo",
                modifier = Modifier
                    .size(120.dp)
                    .alpha(iconAlpha.value)
                    .scale(iconScale.value),
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Crystal Rock Coffee",
                color = Color(0xFFD4AF37),
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.sp,
                modifier = Modifier.alpha(textAlpha.value),
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Premium Coffee & Delights",
                color = Color(0xFFD4AF37).copy(alpha = 0.7f),
                fontSize = 13.sp,
                letterSpacing = 1.2.sp,
                modifier = Modifier.alpha(textAlpha.value),
            )
        }
    }
}
