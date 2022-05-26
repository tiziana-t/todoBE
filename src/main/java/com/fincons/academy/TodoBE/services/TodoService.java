package com.fincons.academy.TodoBE.services;

import java.util.List;


import com.fincons.academy.TodoBE.dto.TodoDto;

public interface TodoService {

	List<TodoDto> getAllTodos();

	Integer creadeNewTodo(TodoDto todoDto);

	void deleteTdo(Integer idTodo);

	TodoDto updateTodo(Integer idTodo, TodoDto dto);

}
