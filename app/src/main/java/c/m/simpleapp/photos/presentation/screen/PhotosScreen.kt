package c.m.simpleapp.photos.presentation.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import c.m.simpleapp.R
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PhotosScreen(navigator: DestinationsNavigator) {
    Text(text = stringResource(id = R.string.photos_screen))
}