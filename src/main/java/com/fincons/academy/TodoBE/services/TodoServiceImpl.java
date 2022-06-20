package com.fincons.academy.TodoBE.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
	
	public TodoServiceImpl(TodoRepository todoRepository) {
		this.todoRepo = todoRepository;
	}
	
	
	
	//*************GET*************
	
	//GET all
	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<TodoDto> getAllTodos(){
		List<TodoDto> dto = new ArrayList<TodoDto>();
		
		try {
		List<Todo> todos = todoRepo.findAll();
		todos.stream().forEach(t->dto.add(TodoUtils.fromEntityToDto(t)));}
		catch(Exception e) {
			logger.info("Memo non trovati");
		}
		return dto;
		
	}
	
	//GET by keyword
	@Override
	@Transactional(propagation = Propagation.NEVER, readOnly = true)
	public List<TodoDto> getByKeyword(String keyword){
		List<TodoDto> dto = new ArrayList<TodoDto>();
		try {
		List<Todo> todos = todoRepo.findByKeyword(keyword);
		todos.stream().forEach(t->dto.add(TodoUtils.fromEntityToDto(t)));

		}
		catch(Exception e) {
			logger.info("keyword non trovata");
			
		}

		return dto;
	}
	
	
	//*************POST*************
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Integer createNewTodo(TodoDto todoDto) {
		Todo todo = new Todo();
		todo = TodoUtils.fromDtoToEntity(todoDto);
		try {
			Todo t = todoRepo.save(todo); //perchè qui non creo una nuova istanza o lo sta facendo lui
			if(t.getText() == null) {
				logger.info("campo -Testo- incompleto");
			}
			if(t.getCreatedAt() == null) {
				logger.info("campo -Data creazione- incompleto");
			}
			if(t.getDueTo()== null) {
				logger.info("campo -Scadenza- incompleto");
			}
			if(t.getState()== null) {
				logger.info("campo -Stato- incompleto");
			}
			return t.getId();
			
		}
		catch(Exception e) {
			logger.info("Errore nella generazione del nuovo memo");
			return -1; //ha senso?

		}
		

	}
	
	//*************PUT*************
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public TodoDto updateTodo(Integer idTodo, TodoDto dto) {
		Todo todo = new Todo();
		TodoDto dtoToReturn = new TodoDto();
		
		try {
		todo.setId(idTodo);
		todo.setText(dto.getText());
		todo.setState(dto.getState());
		todo.setCreatedAt(dto.getCreatedAt());
		todo.setDueTo(dto.getDueTo());
		todoRepo.saveAndFlush(todo);		
		}
		catch(Exception e){
			logger.info("Operazione di update non riuscita");
		}
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
		try {
		todoRepo.delete(todoRepo.getById(idTodo));
		}
		catch(Exception e){
			logger.info("id non trovato");
		}
		
	}

}
