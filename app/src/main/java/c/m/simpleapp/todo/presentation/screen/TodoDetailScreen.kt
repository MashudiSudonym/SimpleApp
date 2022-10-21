package c.m.simpleapp.todo.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Dangerous
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import c.m.simpleapp.common.presentation.navigation_graph.DetailsNavGraph
import c.m.simpleapp.todo.domain.model.Todo
import com.ramcosta.composedestinations.annotation.Destination

@DetailsNavGraph(start = true)
@Destination
@Composable
fun TodoDetailScreen(todo: Todo?) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = todo?.title ?: "Not Found!",
            style = MaterialTheme.typography.h6,
            color = MaterialTheme.colors.surface,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        if (!todo?.title.isNullOrBlank()) {
            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(text = "Task completed : ")
                Icon(
                    imageVector = if (todo?.completed == true) {
                        Icons.Default.CheckCircle
                    } else {
                        Icons.Default.Dangerous
                    },
                    contentDescription = null,
                    tint = if (todo?.completed == true) {
                        Color.Green
                    } else {
                        Color.Red
                    },
                )
            }
        }
    }
}