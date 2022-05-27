package com.fincons.academy.TodoBE.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fincons.academy.TodoBE.dto.TodoDto;
import com.fincons.academy.TodoBE.services.TodoService;

@RestController
@RequestMapping("")
public class TodoRestController {
	
	private TodoService todoService;
	
	public TodoRestController(TodoService todoService) {
		this.todoService = todoService;
	}
	
//**************GET**************
	
	@GetMapping("/getAll")
	public List<TodoDto> getAllTodo(){
		List<TodoDto> dto = todoService.getAllTodos();
		return dto;
	}
	
	@GetMapping("/cercaMemo")
	public List<TodoDto> getByKeyword(String keyword){
		List<TodoDto> dto = todoService.getByKeyword(keyword);
		return dto;
	}
	
//**************POST**************
	
	@PostMapping("/creaNuovo/{keyword}")
	public Integer create(@RequestBody TodoDto dto) {
		Integer key = todoService.creadeNewTodo(dto);
		return key;
	}
	
//**************PUT**************
	
	@PutMapping("/modifica/{id}")
	public TodoDto update(@PathVariable("id") Integer id, @RequestBody TodoDto dto) {
		return todoService.updateTodo(id, dto);
	}
	
	
//**************DELETE**************
	
	@DeleteMapping("/getAll/{id}")
	public void delete(@PathVariable("id") Integer id) {
		todoService.deleteTdo(id);
	}

}
