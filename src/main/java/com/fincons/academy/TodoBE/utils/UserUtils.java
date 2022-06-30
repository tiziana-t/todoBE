package com.fincons.academy.TodoBE.utils;

import com.fincons.academy.TodoBE.dto.UserDto;
import com.fincons.academy.TodoBE.entities.User;

public class UserUtils {
	
	private UserUtils() {} // perchè costruttore privato?
	
	public static UserDto fromEntityToDto(User user) {
		UserDto dto = new UserDto();
		//dto.setId(user.getId());
	}

}
