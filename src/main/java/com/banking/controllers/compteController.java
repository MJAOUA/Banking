package com.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.Compte;
import com.banking.services.CompteService;

@RestController
@CrossOrigin ("http://localhost:4200")
public class compteController {
	
	@Autowired
	CompteService compteservice;

	
	// http://localhost:8082/SpringMVC/servlet/retrieve-all-comptes
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieve-all-comptes")
	  @ResponseBody
	  public List<Compte> getContracts(){
		  List<Compte> list = compteservice.RetrieveAllComptes();
		  return list;
	  }
	
		// http://localhost:8082/SpringMVC/servlet/add-department
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/add-compte")
		@ResponseBody
		public Compte addCompte(@RequestBody Compte C) {
		Compte cpt = compteservice.AddCompte(C);
		return cpt;
		}
}
