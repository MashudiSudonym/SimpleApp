package c.m.simpleapp.todo.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Todo(
    val userId: Int,
    val id: Int,
    val title: String,
    val completed: Boolean,
) : Parcelable
