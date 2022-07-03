package c.m.simpleapp.todo.data.local

import androidx.room.*
import c.m.simpleapp.todo.data.local.entity.TodoEntity

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTodo(todoEntity: TodoEntity)

    @Query("DELETE FROM tbl_todo WHERE todo_id LIKE :todoId")
    suspend fun deleteTodo(todoId: Int)

    @Transaction
    suspend fun updateTodo(todoId: Int, todoEntity: TodoEntity) {
        deleteTodo(todoId)
        insertTodo(todoEntity)
    }

    @Query("SELECT * FROM tbl_todo")
    suspend fun getListTodo(): List<TodoEntity>

    @Query("SELECT * FROM tbl_todo WHERE todo_id LIKE :todoId")
    suspend fun getTodoDetail(todoId: Int): TodoEntity
}