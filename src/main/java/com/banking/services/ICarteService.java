package com.banking.services;

import java.util.List;

import com.banking.entities.Carte;



public interface ICarteService {

	List<Carte> RetrieveAllCartes();

	Carte AddCarte(Carte c);

	void DeleteCarte(Long id);

	Carte UpdateCarte(Carte c);

}
