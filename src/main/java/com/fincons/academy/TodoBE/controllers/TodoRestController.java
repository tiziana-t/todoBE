package com.fincons.academy.TodoBE.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.TodoBE.dto.TodoDto;
import com.fincons.academy.TodoBE.services.TodoService;

@RestController
@RequestMapping("/")
public class TodoRestController {
	
	private TodoService todoService;
	
	public TodoRestController(TodoService todoService) {
		this.todoService = todoService;
	}
	
//**************GET***************
	
	@GetMapping()
	public List<TodoDto> getAllTodo(){
		List<TodoDto> dto = todoService.getAllTodos();
		return dto;
	}

}
