package com.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.banking.entities.*;
import com.banking.repository.*;

@Service
public class CarteService implements ICarteService{

	@Autowired
	CarteRepository CarteRepository;
	CompteRepository CompteRepository;
	
	@Override
	public List<Carte> RetrieveAllCartes(){
		List<Carte> carte = (List<Carte>) CarteRepository.findAll();
		return carte;
	}
	
	@Override
	public Carte AddCarte(Carte c) {
		Carte carte = null;
		carte = CarteRepository.save(c);
		return carte;
	}
	
	@Override
	public void DeleteCarte(Long id) {
		CarteRepository.findById(id).get().setIdcarte(null);
		CarteRepository.deleteById(id);
	}
	
	@Override
	public Carte UpdateCarte(Carte c) {
		Carte CarteUpdated = CarteRepository.save(c);
		return CarteUpdated;
	}	
	
	@Override
	public List<Carte> RetrieveActiveUserCartes(Long id)
	{
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return CarteRepository.RetrieveActiveUserCartes(id);
	}
	
	
	@Override
	public void AssignCarte(long compteid, long carteid){
		Carte carte =CarteRepository.findById(carteid).get();
		Compte compte = CompteRepository.findById(compteid).get();
		carte.setCompte(compte);
		CarteRepository.save(carte);		
	} 
}
