package com.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.*;
import com.banking.services.*;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService UserService;
  	
	@GetMapping("/userinfo/{username}")
	@ResponseBody
	public User getUserinfo(@PathVariable("username") String username) {
	 return UserService.RetrieveUserinfo(username);
	}
	
	
	@PutMapping("/updateuser")
	@ResponseBody
	public User updateUser(@RequestBody User user){
	return UserService.UpdateUser(user);
	}
	
	@GetMapping("/getusers")
	@ResponseBody
	public List<User> getUsers() {
	 return UserService.RetrieveAllUsers();
	}
	
	@GetMapping("/getclients")
	@ResponseBody
	public List<User> getClients() {
	 return UserService.RetrieveClients();
	}
	
}