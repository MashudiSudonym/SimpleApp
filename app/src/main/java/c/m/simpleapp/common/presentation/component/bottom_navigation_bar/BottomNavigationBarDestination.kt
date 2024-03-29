package c.m.simpleapp.common.presentation.component.bottom_navigation_bar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Note
import androidx.compose.material.icons.filled.PhotoAlbum
import androidx.compose.ui.graphics.vector.ImageVector
import c.m.simpleapp.R
import c.m.simpleapp.destinations.DirectionDestination
import c.m.simpleapp.destinations.ListTodoScreenDestination
import c.m.simpleapp.destinations.PhotosScreenDestination
import c.m.simpleapp.destinations.PostsScreenDestination

enum class BottomNavigationBarDestination(
    val direction: DirectionDestination,
    val icon: ImageVector,
    @StringRes val label: Int,
) {
    Todo(
        ListTodoScreenDestination,
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