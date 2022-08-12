package c.m.simpleapp.common.presentation.screen

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.compose.rememberNavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.common.presentation.component.bottom_navigation_bar.BottomNavigationBar
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun RootScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) { padding ->
        DestinationsNavHost(
            modifier = Modifier
                .padding(
                    start = padding.calculateStartPadding(
                        layoutDirection = LayoutDirection.Ltr),
                    end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                ),
            navController = navController,
            navGraph = NavGraphs.root,
        )
    }
}
