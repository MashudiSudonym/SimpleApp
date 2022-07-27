package c.m.simpleapp.common.presentation.component.custom

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.ui.theme.SimpleAppTheme

@Composable
fun AppBarCustom(
    modifier: Modifier = Modifier,
    title: String = stringResource(id = R.string.app_name),
    backgroundColor: Color = MaterialTheme.colors.primary,
    textColor: Color = MaterialTheme.colors.surface,
) {
    TopAppBar(modifier = modifier, backgroundColor = backgroundColor) {
        Spacer(modifier = Modifier.size(16.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = textColor,
        )
        Spacer(modifier = Modifier.weight(1F))
    }
}

@Preview(showBackground = true)
@Composable
private fun AppBarTitleTextCustomPreview() {
    SimpleAppTheme {
        Surface {
            AppBarCustom(modifier = Modifier, title = "Simple Application")
        }
    }
}