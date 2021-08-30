package com.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.*;
import com.banking.repository.*;



@Service
public class CompteService implements ICompteService{

	@Autowired
	CompteRepository CompteRepository;
	UserRepository UserRepository;
	HistoriqueRepository HistoriqueRepository;
	HistoriqueService HistoriqueService;
	
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
		//CompteRepository.findById(id).get().setUser(null);
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
	public void AssignCompte(long compteid, long userid){
		User u =CompteRepository.RetrieveUser(userid);
		Compte c = CompteRepository.findById(compteid).get();
		c.setUser(u);
		CompteRepository.save(c);		
	} 
	
	@Override
	public void TransfertCompteCompte(String rib1,String rib2, float montant){
		Long idc1 = CompteRepository.FindByRib(rib1).getIdcompte();
		Long idc2 = CompteRepository.FindByRib(rib2).getIdcompte();
		Compte c1 = CompteRepository.findById(idc1).get();
		Compte c2 = CompteRepository.findById(idc2).get();
		c1.setSoldeactuel(CompteRepository.findById(idc1).get().getSoldeactuel()-montant);
		c2.setSoldeactuel(CompteRepository.findById(idc2).get().getSoldeactuel()+montant);
		c1.setSoldedisponible(CompteRepository.findById(idc1).get().getSoldedisponible()-montant);
		//HistoriqueService.AddHistorique(idc1, idc2, montant, "Virement");
		CompteRepository.save(c1);
		CompteRepository.save(c2);
	}
	
	@Override
	public List<Compte> RetrieveActiveUserComptes(Long id) {
		//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return CompteRepository.RetrieveActiveUserComptes(id);
	}
	
	@Override
	public User RetrieveUserById(long id) {
		return CompteRepository.RetrieveUser(id);
	}

}
