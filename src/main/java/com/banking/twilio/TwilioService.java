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
	
}
