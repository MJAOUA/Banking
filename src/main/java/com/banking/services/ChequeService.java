package com.banking.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.entities.*;
import com.banking.repository.*;

@Service
public class ChequeService implements IChequeService{

	@Autowired
	ChequeRepository ChequeRepository;
	
	@Override
	public List<Cheque> RetrieveAllCheques(){
		List<Cheque> carte = (List<Cheque>) ChequeRepository.findAll();
		return carte;
	}
	
	@Override
	public Cheque AddCheque(Cheque c) {
		Cheque cheque = null;
		cheque = ChequeRepository.save(c);
		return cheque;
	}
	
	@Override
	public void DeleteCheque(Long id) {
		ChequeRepository.findById(id).get().setCompte(null);
		ChequeRepository.deleteById(id);
	}
	
	@Override
	public Cheque UpdateCheque(Cheque c) {
		Cheque ChequeUpdated = ChequeRepository.save(c);
		return ChequeUpdated;
	}	
	
	
}
