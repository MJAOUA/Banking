package com.banking.services;

import java.util.List;

import com.banking.entities.Compte;
import com.banking.entities.User;



public interface ICompteService {

	List<Compte> RetrieveAllComptes();

	Compte AddCompte(Compte c);

	void DeleteCompte(Long id);

	Compte UpdateCompte(Compte c);

	Compte RetrieveCompte(String id);


	List<Compte> RetrieveActiveUserComptes(Long id);

	void TransfertCompteCompte(String rib1, String rib2, float montant);

	void AssignCompte(long compteid, long userid);

	User RetrieveUserById(long id);

}
