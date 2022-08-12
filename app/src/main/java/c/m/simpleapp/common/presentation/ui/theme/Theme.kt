package c.m.simpleapp.common.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val DarkColorPalette = darkColors(
    primary = ThirdColor,
    primaryVariant = ThirdColor,
    secondary = SecondColor,
    surface = Color.White
)

private val LightColorPalette = lightColors(
    primary = FirstColor,
    primaryVariant = FirstVariantColor,
    secondary = SecondColor,
    surface = ThirdColor

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun SimpleAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    val systemUIController = rememberSystemUiController()

    SideEffect {
        systemUIController.setStatusBarColor(
            color = colors.primary,
            darkIcons = !darkTheme
        )
        systemUIController.setNavigationBarColor(
            color = colors.primary
        )
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}