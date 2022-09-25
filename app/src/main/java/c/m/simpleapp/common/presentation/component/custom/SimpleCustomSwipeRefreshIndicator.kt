package c.m.simpleapp.common.presentation.component.custom

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import c.m.simpleapp.common.presentation.component.util.AdaptiveCustomColor
import com.google.accompanist.swiperefresh.SwipeRefreshIndicator
import com.google.accompanist.swiperefresh.SwipeRefreshState

@Composable
fun SimpleCustomSwipeRefreshIndicator(state: SwipeRefreshState, trigger: Dp) {
    SwipeRefreshIndicator(
        state = state,
        refreshTriggerDistance = trigger,
        backgroundColor = AdaptiveCustomColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = MaterialTheme.colors.background,
            onLight = MaterialTheme.colors.secondary,
        ),
        contentColor = AdaptiveCustomColor(
            isDarkTheme = isSystemInDarkTheme(),
            onDark = MaterialTheme.colors.surface,
            onLight = MaterialTheme.colors.primary,
        )
    )
}