package c.m.simpleapp.todo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import c.m.simpleapp.todo.data.local.entity.TodoEntity

@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class TodoLocalDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao
}