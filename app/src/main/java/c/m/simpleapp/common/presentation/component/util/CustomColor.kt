package c.m.simpleapp.common.presentation.component.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


/**
 * this file is used to store custom color settings that will be used repeatedly in jetpack compose files.
 */

// If you need dynamic background color on dark theme and light theme for ui component
@Composable
fun AdaptiveCustomColor(isDarkTheme: Boolean, onDark: Color, onLight: Color): Color =
    if (isDarkTheme) {
        onDark
    } else {
        onLight
    }