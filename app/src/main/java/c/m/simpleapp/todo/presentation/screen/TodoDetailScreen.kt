package c.m.simpleapp.todo.presentation.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.common.presentation.navigation_graph.DetailsNavGraph
import com.ramcosta.composedestinations.annotation.Destination

@DetailsNavGraph(start = true)
@Destination
@Composable
fun TodoDetailScreen() {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            AppBarCustom(title = "Todo detail")
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {

    }
}