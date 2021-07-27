package com.banking.services;

import java.util.List;

import com.banking.entities.Compte;



public interface ICompteService {

	List<Compte> RetrieveAllComptes();

	Compte AddCompte(Compte c);

	void DeleteCompte(Long id);

	Compte UpdateCompte(Compte c);

	Compte RetrieveCompte(String id);

	void AssignCompte(Long compteid, Long userid);

	void TransfertCompteCompte(Long idc1, Long idc2, float montant);

	List<Compte> RetrieveActiveUserComptes(Long id);

}
