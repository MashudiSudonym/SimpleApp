package c.m.simpleapp.todo.presentation.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import c.m.simpleapp.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun TodoScreen(navigator: DestinationsNavigator) {
    Text(text = stringResource(id = R.string.todo_screen))
}