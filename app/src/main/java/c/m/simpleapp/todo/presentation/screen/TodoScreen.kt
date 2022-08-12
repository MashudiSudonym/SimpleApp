package c.m.simpleapp.todo.presentation.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.common.presentation.component.custom.BottomNavigationContentWrapperCustom
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun TodoScreen(navigator: DestinationsNavigator) {
    BottomNavigationContentWrapperCustom {
        Scaffold(
            topBar = {
                AppBarCustom(title = "Todo")
            },
        ) { padding ->
            LazyColumn(
                modifier = Modifier
                    .padding(
                        start = padding.calculateStartPadding(
                            layoutDirection = LayoutDirection.Ltr),
                        end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding()
                    )
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                item {
                    for (i in 1..100) {
                        Text("Hello $i", modifier = Modifier.padding(16.dp))
                    }
                }
            }
        }
    }
}