package com.fincons.academy.TodoBE.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fincons.academy.TodoBE.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	
	User getByUsername(String username);
	
	

}
