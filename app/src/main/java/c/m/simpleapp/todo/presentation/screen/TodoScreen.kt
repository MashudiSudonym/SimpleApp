package c.m.simpleapp.todo.presentation.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.common.presentation.component.custom.BottomNavigationContentWrapperCustom
import c.m.simpleapp.todo.presentation.component.TodoContent
import c.m.simpleapp.todo.presentation.view_model.TodoViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun TodoScreen(navigator: DestinationsNavigator, todoViewModel: TodoViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()

    BottomNavigationContentWrapperCustom {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBarCustom(title = stringResource(id = R.string.todo_screen))
            },
            backgroundColor = MaterialTheme.colors.primary
        ) { padding ->
            TodoContent(padding = padding)
        }
    }
}