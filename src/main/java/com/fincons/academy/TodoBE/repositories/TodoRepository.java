package com.fincons.academy.TodoBE.repositories;

import org.springframework.stereotype.Repository;
import com.fincons.academy.TodoBE.entities.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>  {

	@Query("select t from Todo t where t.text LIKE %:keyword%")
	List<Todo> findByKeyword(@Param("keyword") String text);
	
	List<Todo> findAll();
	
	Todo getById(Integer id);
}
