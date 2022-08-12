package c.m.simpleapp.todo.presentation.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme

@Composable
fun TodoContent(padding: PaddingValues) {
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
                Text(
                    "Hello $i",
                    modifier = Modifier.padding(16.dp),
                    color = MaterialTheme.colors.surface,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TodoContentPreview() {
    SimpleAppTheme {
        Surface {
            TodoContent(padding = PaddingValues())
        }
    }
}