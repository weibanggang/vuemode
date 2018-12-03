package com.nf147.todo.mapper;

import com.nf147.todo.entity.Todo;

import java.util.List;

public interface TodoMapper {
    List<Todo> getTodos();
    int addTodo(Todo todo);
    int deleteTodo(int id);
    int makeDone(int id);
    int makeCancle(int id);
    Todo getTodo(int id);
}
