package com.banking.services;

import java.util.List;

import com.banking.entities.User;



public interface IUserService {

	List<User> RetrieveAllUsers();

	User AddUser(User u);

	void DeleteUser(Long id);

	User UpdateUser(User u);

	User RetrieveUser(String id);
	public User RetrieveUserinfo(String username) ;

	User UpdateThisUser(User user) throws Exception;

}
