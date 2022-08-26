package c.m.simpleapp.common.presentation.component.custom

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Snackbar
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.runtime.Composable

@Composable
fun SimpleCustomSnackBar(hostState: SnackbarHostState) {
    SnackbarHost(hostState = hostState) { data ->
        Snackbar(
            snackbarData = data,
            contentColor = MaterialTheme.colors.primary,
            backgroundColor = MaterialTheme.colors.surface,
        )
    }
}