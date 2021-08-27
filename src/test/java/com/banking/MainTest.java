package com.banking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.services.ICompteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

	@Autowired
	ICompteService is;
	
	/*@Test		
	public void TestDeleteCompte() {
		is.TransfertCompteCompte("1234657834212", "2132111231221", 1000);
	}*/
}
