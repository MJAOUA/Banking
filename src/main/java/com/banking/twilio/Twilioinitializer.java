package com.banking.twilio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.twilio.Twilio;

@Configuration
public class Twilioinitializer {

	private final static Logger Logger=LoggerFactory.getLogger(Twilioinitializer.class);
	private final TwilioConfiguration twilioConfiguration;

	@Autowired
	public Twilioinitializer(TwilioConfiguration twilioConfiguration) {
		this.twilioConfiguration = twilioConfiguration;
		Twilio.init(twilioConfiguration.getAccountSid(), twilioConfiguration.getAuthToken());
		Logger.info("Twilio initialized with Account SID :"+twilioConfiguration.getAccountSid());
	}
	
	
	
	
}
