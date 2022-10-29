package c.m.simpleapp.todo.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.LayoutDirection
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.*
import c.m.simpleapp.common.presentation.component.util.AdaptiveCustomColor
import c.m.simpleapp.todo.presentation.component.ListTodoContent
import c.m.simpleapp.todo.presentation.event.TodoUIStatusEvent
import c.m.simpleapp.todo.presentation.view_model.TodoViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalLifecycleComposeApi::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun ListTodoScreen(
    navigator: DestinationsNavigator,
    todoViewModel: TodoViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()
    val context = LocalContext.current
    val listTodoUIState by todoViewModel.listTodoUIState.collectAsStateWithLifecycle()
    val todoUIStatusEvent = todoViewModel.todoUIStatusEvent

    BottomNavigationContentWrapperCustom {
        Scaffold(
            scaffoldState = scaffoldState,
            snackbarHost = { snackbarHostState ->
                SimpleCustomSnackBar(snackbarHostState)
            },
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
                val isNotSuccessState = listTodoUIState.isLoading || listTodoUIState.isError

                if (isNotSuccessState) {
                    LocalContentBanner(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(
                                color = AdaptiveCustomColor(
                                    isDarkTheme = isSystemInDarkTheme(),
                                    onDark = MaterialTheme.colors.secondary,
                                    onLight = MaterialTheme.colors.surface,
                                ),
                            ),
                    )
                }

                // swipe refresh
                SwipeRefresh(
                    state = rememberSwipeRefreshState(isRefreshing = listTodoUIState.isRefresh),
                    onRefresh = { todoViewModel.getListTodoFromSwipeRefresh() },
                    indicator = { state, trigger ->
                        SimpleCustomSwipeRefreshIndicator(state, trigger)
                    },
                ) {
                    // list todos Content UI
                    ListTodoContent(
                        modifier = Modifier
                            .padding(
                                start = padding.calculateStartPadding(layoutDirection = LayoutDirection.Ltr),
                                end = padding.calculateEndPadding(layoutDirection = LayoutDirection.Ltr),
                                top = padding.calculateTopPadding(),
                                bottom = padding.calculateBottomPadding(),
                            )
                            .fillMaxSize(),
                        listTodoUIState = listTodoUIState,
                        navigator = navigator,
                    )
                }
            }
        }
    }
}