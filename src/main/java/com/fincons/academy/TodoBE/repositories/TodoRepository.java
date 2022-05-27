package com.fincons.academy.TodoBE.repositories;

import org.springframework.stereotype.Repository;
import com.fincons.academy.TodoBE.entities.Todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>  {

	//Metodo di supporto alla funzionalità di ricerca dei memo in memoria attraverso la parola chiave implementato in interfaccia
	@Query("select t from Todo t where t.text like %:keyword%")
	List<Todo> findByKeyword(@Param("keyword") String text);
	
	//Metodo di supporto alla funzionalità che mostra tutti i memo in memoria implementata in interfaccia
	List<Todo> findAll();
	
	//Metodo che supporta le funzionalità di modifica ed eliminazione dei memo in memoria
	Todo getById(Integer id);
}
