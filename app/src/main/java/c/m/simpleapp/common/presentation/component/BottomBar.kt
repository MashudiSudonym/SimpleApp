package c.m.simpleapp.common.presentation.component

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.appCurrentDestinationAsState
import c.m.simpleapp.destinations.Destination
import c.m.simpleapp.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomBar(navController: NavController) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    BottomNavigation {
        BottomBarDestination.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigate(destination.direction) {
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = destination.icon,
                        contentDescription = stringResource(id = destination.label),
                    )
                },
                label = {
                    Text(text = stringResource(id = destination.label))
                },
            )
        }
    }
}