package com.banking.services;

import java.util.List;

import com.banking.entities.Historique;

public interface IHistoriqueService {

	Historique AddHistorique(long id1, long id2, float montant, String desc);

	List<Historique> RetrieveAllHistoriques();

	Historique AddHistorique(Historique c);

	void DeleteHistorique(Long id);

	Historique UpdateHistorique(Historique c);

}
