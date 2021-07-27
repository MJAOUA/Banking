package com.banking.services;

import java.util.List;

import com.banking.entities.Cheque;



public interface IChequeService {

	List<Cheque> RetrieveAllCheques();

	Cheque AddCheque(Cheque c);

	void DeleteCheque(Long id);

	Cheque UpdateCheque(Cheque c);

}
