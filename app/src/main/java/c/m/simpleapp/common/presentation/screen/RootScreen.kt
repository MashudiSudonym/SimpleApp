package c.m.simpleapp.common.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.common.presentation.component.bottom_navigation_bar.BottomNavigationBar
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun RootScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }) {
        DestinationsNavHost(navController = navController, navGraph = NavGraphs.root)
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
