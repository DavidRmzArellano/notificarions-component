package com.notification.springboot.sending.app.service;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.notification.springboot.sending.app.model.SendSms;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsSenderService {

	private static final Logger log = LoggerFactory.getLogger(SmsSenderService.class);

	@Value(value = "${twilioSMS-ACCOUNT_SID.value}")
	private String ACCOUNT_SID;
	@Value(value = "${twilioSMS-AUTH_TOKEN.value}")
	private String AUTH_TOKEN;
	@Value(value = "${twilioSMS-TWILIO_NUMBER.value}")
	private String TWILIO_NUMBER;
	
	

	public void sendSms(SendSms sms) throws MessagingException, IOException {

		Map<String, Object> map = sms.getMap();

		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message messageT = Message
				.creator(new PhoneNumber(sms.getPara()), new PhoneNumber(TWILIO_NUMBER),
						"Bienvenid@ " + map.get("name") + " a Yo Consumo, "+ map.get("message"))
				.create();
		log.info("Envio sms");
	}
	
}
