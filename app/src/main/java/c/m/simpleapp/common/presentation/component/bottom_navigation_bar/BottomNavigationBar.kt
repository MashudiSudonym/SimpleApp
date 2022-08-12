package c.m.simpleapp.common.presentation.component.bottom_navigation_bar

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.appCurrentDestinationAsState
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme
import c.m.simpleapp.destinations.Destination
import c.m.simpleapp.startAppDestination
import com.ramcosta.composedestinations.navigation.navigate

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentDestination: Destination =
        navController.appCurrentDestinationAsState().value ?: NavGraphs.root.startAppDestination

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.surface,
        elevation = 0.dp,
    ) {
        BottomNavigationBarDestination.values().forEach { destination ->
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
                    Text(text = stringResource(id = destination.label),
                        style = MaterialTheme.typography.caption)
                },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavigationBarPreview() {
    SimpleAppTheme {
        Surface {
            BottomNavigationBar(navController = rememberNavController())
        }
    }
}