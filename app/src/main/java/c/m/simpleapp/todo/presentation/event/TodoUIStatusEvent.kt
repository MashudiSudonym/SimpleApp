package c.m.simpleapp.todo.presentation.event

sealed class TodoUIStatusEvent {
    object Error : TodoUIStatusEvent()
}
