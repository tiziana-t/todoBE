package com.fincons.academy.TodoBE.utils;

import com.fincons.academy.TodoBE.dto.TodoDto;
import com.fincons.academy.TodoBE.entities.Todo;

public class TodoUtils {
	
	private TodoUtils() {
		}
	
	public static TodoDto fromEntityToDto(Todo todo) {
		TodoDto dto = new TodoDto();
		dto.setText(todo.getText());
		dto.setState(todo.getState());
		dto.setCreatedAt(todo.getCreatedAt());
		dto.setDueTo(todo.getDueTo());
		return dto;
		
	}
	
	public static Todo fromDtoToEntity (TodoDto dto) {
		Todo todo = new Todo();
		todo.setId(dto.getId());
		todo.setText(dto.getText());
		todo.setState(dto.getState());
		todo.setCreatedAt(dto.getCreatedAt());
		todo.setDueTo(dto.getDueTo());
		
		return todo;
	}

}
