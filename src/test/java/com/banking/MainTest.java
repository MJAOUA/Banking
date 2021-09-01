package com.banking;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.services.ICompteService;
import com.banking.twilio.SmsRequest;
import com.banking.twilio.TwilioService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTest {

	@Autowired
	ICompteService is;
	@Autowired
	TwilioService ts;
	private static final Logger L= LogManager.getLogger(MainTest.class);

	/*
	@Test
	public void test() {
		SmsRequest smsRequest =new SmsRequest("+21653588922","TESTEST");
		ts.sendSms(smsRequest);
	}*/
	
	/*
	@Test		
	public void TestDeleteCompte() {
	     int min = 10000;
	      int max = 99999;
	        
	      System.out.println("Random value in int from "+min+" to "+max+ ":");
	      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
	      System.out.println(random_int);
	}*/
}
