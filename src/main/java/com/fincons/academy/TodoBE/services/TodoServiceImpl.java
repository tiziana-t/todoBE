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
	
	
	
	//*************GET*************
	
	//GET all
	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<TodoDto> getAllTodos(){
		List<TodoDto> dto = new ArrayList<TodoDto>();
		List<Todo> todos = todoRepo.findAll();
		todos.stream().forEach(t->dto.add(TodoUtils.fromEntityToDto(t)));
		return dto;
		
	}
	
	
	//*************POST*************
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer creadeNewTodo(TodoDto todoDto) {
		Todo todo = new Todo();
		todo = TodoUtils.fromDtoToEntity(todoDto);
		Todo t = todoRepo.save(todo); //perchè qui non creo una nuova istanza o lo sta facendo lui
		return t.getId();
	}
	
	//*************PUT*************
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TodoDto updateTodo(Integer idTodo, TodoDto dto) {
		todoRepo.delete(todoRepo.getById(idTodo));
		Todo todo = new Todo();
		todo.setText(dto.getText());
		todo.setState(dto.getState());
		todo.setCreatedAt(dto.getCreatedAt());
		todo.setDueTo(dto.getDueTo());
		todoRepo.saveAndFlush(todo);
		
		TodoDto dtoToReturn = new TodoDto();
		dtoToReturn.setId(todo.getId());
		dtoToReturn.setText(todo.getText());
		dtoToReturn.setState(todo.getState());
		dtoToReturn.setCreatedAt(todo.getCreatedAt());
		dtoToReturn.setDueTo(todo.getDueTo());
		
		return dtoToReturn;
	}
	
	//*************DELETE*************
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteTdo(Integer idTodo) {
		todoRepo.delete(todoRepo.getById(idTodo));
	}

}
