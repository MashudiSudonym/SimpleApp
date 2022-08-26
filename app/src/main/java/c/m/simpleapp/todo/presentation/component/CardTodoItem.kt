package c.m.simpleapp.todo.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.RadioButtonChecked
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme

@Composable
fun CardTodoItem(
    modifier: Modifier,
    elevation: Dp,
    backgroundColor: Color,
    title: String,
    complete: Boolean,
) {
    Card(modifier = modifier, elevation = elevation, backgroundColor = backgroundColor) {
        Row(modifier = Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.surface,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.weight(1F),
            )
            Spacer(modifier = Modifier.weight(1F))
            Icon(
                imageVector = if (complete) {
                    Icons.Default.RadioButtonChecked
                } else {
                    Icons.Default.RadioButtonUnchecked
                },
                contentDescription = null,
                tint = MaterialTheme.colors.surface,
            )
        }
    }
}

@Preview
@Composable
private fun CardTodoItemPreview() {
    SimpleAppTheme {
        Surface {
            CardTodoItem(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { },
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 4.dp,
                title = "laboriosan mollitia et enim quasi adapisci wuinasnalsnl",
                complete = true,
            )
        }
    }
}