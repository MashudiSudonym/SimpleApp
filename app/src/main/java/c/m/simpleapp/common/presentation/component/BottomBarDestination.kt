package c.m.simpleapp.common.presentation.component

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.PhotoAlbum
import androidx.compose.ui.graphics.vector.ImageVector
import c.m.simpleapp.R
import c.m.simpleapp.destinations.DirectionDestination
import c.m.simpleapp.destinations.PhotosScreenDestination
import c.m.simpleapp.destinations.PostsScreenDestination
import c.m.simpleapp.destinations.TodoScreenDestination

enum class BottomBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Todo(
        TodoScreenDestination,
        Icons.Filled.CalendarToday,
        R.string.todo_screen,
    ),
    PostsScreen(
        PostsScreenDestination,
        Icons.Filled.Note,
        R.string.posts_screen,
    ),
    PhotosScreen(
        PhotosScreenDestination,
        Icons.Filled.PhotoAlbum,
        R.string.photos_screen,
    )
}