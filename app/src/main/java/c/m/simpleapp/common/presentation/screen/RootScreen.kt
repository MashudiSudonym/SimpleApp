package c.m.simpleapp.common.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.common.presentation.component.bottom_navigation_bar.BottomNavigationBar
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme
import c.m.simpleapp.destinations.TodoDetailScreenDestination
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import timber.log.Timber

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun RootScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Timber.w(currentRoute)
    Timber.w(TodoDetailScreenDestination.route)

    Scaffold(
        bottomBar = {
            NavGraphs.root.destinations.forEach { destination ->
                if (currentRoute == destination.route) {
                    BottomNavigationBar(navController = navController)
                }
            }
        }) {
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root,
            modifier = Modifier.background(color = MaterialTheme.colors.primary),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RootScreenPreview() {
    SimpleAppTheme {
        Surface {
            RootScreen()
        }
    }
}
