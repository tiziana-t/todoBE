package com.fincons.academy.TodoBE.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fincons.academy.TodoBE.dto.TodoDto;
import com.fincons.academy.TodoBE.entities.Todo;
import com.fincons.academy.TodoBE.repositories.TodoRepository;
import com.fincons.academy.TodoBE.utils.TodoUtils;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class TodoServiceImpl implements TodoService{
	
	private TodoRepository todoRepo;
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepo = todoRepository;
	}
	
	//*************GET**************
	
	//GET all
	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<TodoDto> getAllTodos(){
		List<TodoDto> dto = new ArrayList<TodoDto>();
		List<Todo> todos = todoRepo.findAll();
		todos.stream().forEach(t->dto.add(TodoUtils.fromEntityToDto(t)));
		return dto;
		
	}

}
