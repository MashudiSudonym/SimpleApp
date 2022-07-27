package c.m.simpleapp.todo.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
            Column(modifier = Modifier.padding(padding)) {
                Text(text = "hello")
            }
        }
    }
}