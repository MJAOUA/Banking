package com.banking.twilio;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin (origins="http://localhost:4200")
public class TwilioController {

	private final TwilioService twilioService;
	@Autowired
	public TwilioController(TwilioService twilioService) {
		this.twilioService = twilioService;
	}

	@PostMapping
	public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
		twilioService.sendSms(smsRequest);
	}
}
