package com.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.banking.entities.*;
import com.banking.repository.*;



@Service
public class CompteService implements ICompteService{

	@Autowired
	CompteRepository CompteRepository;
	UserRepository UserRepository;
	TransactionRepository TransactionRepository;
	
	@Override
	public List<Compte> RetrieveAllComptes(){
		List<Compte> compte = (List<Compte>) CompteRepository.findAll();
		return compte;
	}
	
	@Override
	public Compte AddCompte(Compte c) {
		Compte compte = null;
		compte = CompteRepository.save(c);
		return compte;
	}
	
	@Override
	public void DeleteCompte(Long id) {
		CompteRepository.findById(id).get().setUser(null);
		CompteRepository.deleteById(id);
	}
	
	@Override
	public Compte UpdateCompte(Compte c) {
		Compte CompteUpdated = CompteRepository.save(c);
		return CompteUpdated;
	}	
	
	@Override
	public Compte RetrieveCompte(String id){
		Compte c = CompteRepository.findById(Long.parseLong(id)).get();
		return c;
	}
	
	@Override
	public void AssignCompte(Long compteid, Long userid){
		User u =UserRepository.findById(userid).get();
		CompteRepository.findById(compteid).get().setUser(u);
	} 
	
	@Override
	public void TransfertCompteCompte(Long idc1,Long idc2, float montant){
		CompteRepository.findById(idc1).get().setSoldeactuel(CompteRepository.findById(idc1).get().getSoldeactuel()-montant);
		CompteRepository.findById(idc2).get().setSoldeactuel(CompteRepository.findById(idc1).get().getSoldeactuel()+montant);
		Transaction tr = new Transaction();
		tr.setId1(idc1);
		tr.setId2(idc2);
		tr.setMontant(montant);
	}
	
	@Override
	public List<Compte> RetrieveActiveUserComptes(Long id) {
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return CompteRepository.RetrieveActiveUserComptes(id);
	}
	
	

}
