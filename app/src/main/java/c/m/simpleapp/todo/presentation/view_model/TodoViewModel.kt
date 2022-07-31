package c.m.simpleapp.todo.presentation.view_model

import androidx.lifecycle.ViewModel
import c.m.simpleapp.todo.domain.use_case.get_list_todo_use_case.GetListTodoUseCase
import c.m.simpleapp.todo.domain.use_case.get_todo_detail_use_case.GetTodoDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val getListTodoUseCase: GetListTodoUseCase,
    private val getTodoDetailUseCase: GetTodoDetailUseCase,
) : ViewModel()