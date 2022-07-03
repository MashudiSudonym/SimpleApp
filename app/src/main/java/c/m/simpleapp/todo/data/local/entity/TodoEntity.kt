package c.m.simpleapp.todo.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_todo")
data class TodoEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    val id: Long = 0L,
    @ColumnInfo(name = "user_id")
    val userId: Int = 0,
    @ColumnInfo(name = "todo_id")
    val todoId: Int = 0,
    @ColumnInfo(name = "title")
    val title: String = "",
    @ColumnInfo(name = "completed")
    val completed: Boolean = false,
)