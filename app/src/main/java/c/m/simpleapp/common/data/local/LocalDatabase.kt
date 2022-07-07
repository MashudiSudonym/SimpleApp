package c.m.simpleapp.common.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import c.m.simpleapp.posts.data.local.PostsDao
import c.m.simpleapp.posts.data.local.entity.PostEntity
import c.m.simpleapp.todo.data.local.TodoDao
import c.m.simpleapp.todo.data.local.entity.TodoEntity

@Database(
    entities = [TodoEntity::class, PostEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
    abstract fun postsDao(): PostsDao
}