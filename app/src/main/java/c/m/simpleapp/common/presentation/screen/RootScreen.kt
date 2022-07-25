package c.m.simpleapp.common.presentation.screen

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import c.m.simpleapp.NavGraphs
import c.m.simpleapp.common.presentation.component.BottomBar
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Destination
@Composable
fun RootScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomBar(navController = navController)
        }) {
        DestinationsNavHost(navController = navController, navGraph = NavGraphs.root)
    }
}
