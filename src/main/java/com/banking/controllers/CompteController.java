package com.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.Compte;
import com.banking.services.CompteService;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class CompteController {
	
	@Autowired
	CompteService compteservice;

	
	// http://localhost:8082/retrieve-all-comptes
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieve-all-comptes")
	  @ResponseBody
	  public List<Compte> getComptes(){
		  List<Compte> list = compteservice.RetrieveAllComptes();
		  return list;
	  }
	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/add-compte")
		@ResponseBody
		public Compte addCompte(@RequestBody Compte C) {
		Compte cpt = compteservice.AddCompte(C);
		return cpt;
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/delete-compte/{compte-id}")
		@ResponseBody
		public void removeCompte(@PathVariable("compte-id") Long compteId) {
	  		compteservice.DeleteCompte(compteId);
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_USER')")
		@GetMapping("/retrieveuseraccounts/{user-id}")
		@ResponseBody
		public List<Compte> RetrieveActiveUserComptes(@PathVariable("user-id") Long userid) {
	  		return compteservice.RetrieveActiveUserComptes(userid);
		}
	  	
}