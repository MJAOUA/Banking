package com.banking.twilio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
  
@Service
public class TwilioService {

	private final SmsSender smsSender;

	@Autowired
	public TwilioService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
		this.smsSender = twilioSmsSender;
	}
	
	public void sendSms(SmsRequest smsRequest) {
		smsSender.sendSms(smsRequest);
	}
	
	public String sendOTP(String Phonenumber) {
		int min = 10000;
	    int max = 99999;
	    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);	
	    SmsRequest smsRequest = new SmsRequest(Phonenumber,"Votre code de validation est : "+String.valueOf(random_int));
	    smsSender.sendSms(smsRequest);
	    return String.valueOf(random_int);}
}
