package c.m.simpleapp.posts.presentation.screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import c.m.simpleapp.R
import c.m.simpleapp.common.presentation.component.custom.AppBarCustom
import c.m.simpleapp.posts.presentation.view_model.PostsViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PostsScreen(
    navigator: DestinationsNavigator,
    postsViewModel: PostsViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = {
            AppBarCustom(title = stringResource(id = R.string.posts_screen))
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {}
}