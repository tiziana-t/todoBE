package com.fincons.academy.TodoBE.repositories;

import org.springframework.stereotype.Repository;
import com.fincons.academy.TodoBE.entities.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>  {

	List<Todo> findAll();
}
