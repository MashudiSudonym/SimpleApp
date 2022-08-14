package c.m.simpleapp.todo.presentation.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.common.presentation.component.custom.BottomNavigationContentWrapperCustom
import c.m.simpleapp.common.presentation.component.custom.LocalContentBanner
import c.m.simpleapp.todo.presentation.component.TodoContent
import c.m.simpleapp.todo.presentation.event.TodoUIStatusEvent
import c.m.simpleapp.todo.presentation.view_model.TodoViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun TodoScreen(navigator: DestinationsNavigator, todoViewModel: TodoViewModel = hiltViewModel()) {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    val listTodoUIState by todoViewModel.listTodoUIState.collectAsState()
    val todoUIStatusEvent = todoViewModel.todoUIStatusEvent

    BottomNavigationContentWrapperCustom {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBarCustom(title = stringResource(id = R.string.todo_screen))
            },
            backgroundColor = MaterialTheme.colors.primary
        ) { padding ->
            // show snack bar for error state with error message
            LaunchedEffect(key1 = scaffoldState) {
                todoUIStatusEvent.collect { event ->
                    when (event) {
                        TodoUIStatusEvent.Error -> scaffoldState.snackbarHostState.showSnackbar(
                            listTodoUIState.errorMessage?.asString(context).toString()
                        )
                    }
                }
            }

            Column(modifier = Modifier.fillMaxSize()) {
                // if state data on loading or on error, show banner local content
                if (listTodoUIState.isLoading || listTodoUIState.isError) {
                    LocalContentBanner()
                }
                TodoContent(padding = padding, listTodoUIState)
            }
        }
    }
}