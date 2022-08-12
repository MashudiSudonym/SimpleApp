package c.m.simpleapp.photos.presentation.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PhotosScreen(navigator: DestinationsNavigator) {
    Scaffold(
        topBar = {
            AppBarCustom(title = stringResource(id = R.string.photos_screen))
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {}
}