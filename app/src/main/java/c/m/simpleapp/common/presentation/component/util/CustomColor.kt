package c.m.simpleapp.common.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


/**
 * this file is used to store custom color settings that will be used repeatedly in jetpack compose files.
 */

// If you need dynamic background color on dark theme and light theme for ui component
@Composable
fun DynamicBackgroundColor(darkTheme: Boolean, onDark: Color, onLight: Color): Color =
    if (darkTheme) {
        onDark
    } else {
        onLight
    }