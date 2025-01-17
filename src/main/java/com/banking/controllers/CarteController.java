package com.banking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CarteController {
	
	@Autowired
	CarteService CarteService;
	
	
	  @PreAuthorize("hasRole('ROLE_ADMIN')")
	  @GetMapping("/retrieve-all-Cartes")
	  @ResponseBody
	  public List<Carte> getCartes(){
		  List<Carte> list = CarteService.RetrieveAllCartes();
		  return list;
	  }
	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@PostMapping("/add-Carte")
		@ResponseBody
		public Carte addCarte(@RequestBody Carte C) {
		Carte carte = CarteService.AddCarte(C);
		return carte;
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
		@DeleteMapping("/delete-Carte/{Carte-id}")
		@ResponseBody
		public void removeCarte(@PathVariable("Carte-id") Long CarteId) {
	  		CarteService.DeleteCarte(CarteId);
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_USER')")
		@GetMapping("/retrieveusercarte/{user-id}")
		@ResponseBody
		public List<Carte> RetrieveActiveUserComptes(@PathVariable("user-id") Long userid) {
	  		return CarteService.RetrieveActiveUserCartes(userid);
		}
	  	
	  	@PreAuthorize("hasRole('ROLE_ADMIN')")
	  	@PutMapping("/assigncarte/{compteid}/{carteid}")
		@ResponseBody
		public void AssignCompte(@PathVariable("compteid")long compteid,@PathVariable("carteid")long carteid) {
			CarteService.AssignCarte(compteid, carteid);
		}
}