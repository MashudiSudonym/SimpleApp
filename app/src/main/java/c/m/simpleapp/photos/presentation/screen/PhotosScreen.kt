package c.m.simpleapp.photos.presentation.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.common.presentation.component.custom.BottomNavigationContentWrapperCustom
import c.m.simpleapp.photos.presentation.view_model.PhotosViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PhotosScreen(
    navigator: DestinationsNavigator,
    photosViewModel: PhotosViewModel = hiltViewModel(),
) {
    val scaffoldState = rememberScaffoldState()

    BottomNavigationContentWrapperCustom {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                AppBarCustom(title = stringResource(id = R.string.photos_screen))
            },
            backgroundColor = MaterialTheme.colors.primary
        ) {}
    }
}