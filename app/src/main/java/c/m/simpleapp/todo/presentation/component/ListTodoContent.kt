package c.m.simpleapp.todo.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import c.m.simpleapp.todo.presentation.state.ListTodoUIState
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun ListTodoContent(
    modifier: Modifier,
    listTodoUIState: ListTodoUIState,
    navigator: DestinationsNavigator,
) {
    LazyColumn(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        item {
            for (i in 1..100) {
                CardTodoItem(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clickable { },
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = 4.dp,
                    title = "Todo $i",
                    complete = i == i.mod(2),
                )
            }
        }
    }
}