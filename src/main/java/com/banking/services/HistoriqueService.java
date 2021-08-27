package com.banking.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.*;
import com.banking.repository.*;
@Service
public class HistoriqueService implements IHistoriqueService{

	@Autowired
	HistoriqueRepository HistoriqueRepository;
	
	
	@Override
	public List<Historique> RetrieveAllHistoriques(){
		List<Historique> carte = (List<Historique>) HistoriqueRepository.findAll();
		return carte;
	}
	
	@Override
	public Historique AddHistorique(Historique c) {
		Historique Historique = null;
		Historique = HistoriqueRepository.save(c);
		return Historique;
	}
	
	@Override
	public void DeleteHistorique(Long id) {
		HistoriqueRepository.deleteById(id);
	}
	
	@Override
	public Historique UpdateHistorique(Historique c) {
		Historique HistoriqueUpdated = HistoriqueRepository.save(c);
		return HistoriqueUpdated;
	}	
	
	
	@Override
	public Historique AddHistorique(long id1,long id2, float montant, String desc) {
		Historique tr = new Historique();
		tr.setDate(new Date());
		tr.setDescription(desc);
		tr.setId1(id1);
		tr.setId2(id2);
		return HistoriqueRepository.save(tr) ;
	}
	
}
