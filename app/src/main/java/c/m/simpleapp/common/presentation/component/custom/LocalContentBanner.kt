package c.m.simpleapp.common.presentation.component.custom

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme

@Composable
fun LocalContentBanner(modifier: Modifier) {
    Box(modifier = modifier) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "This data from local content",
            style = MaterialTheme.typography.caption,
        )
    }
}

@Preview
@Composable
private fun LocalContentAlertPreview() {
    SimpleAppTheme {
        Surface {
            LocalContentBanner(modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.secondary))
        }
    }
}