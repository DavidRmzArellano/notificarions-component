package com.notification.springboot.sending.app.component;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.notification.springboot.sending.app.model.SendEmail;
import com.notification.springboot.sending.app.model.SendSms;
import com.notification.springboot.sending.app.service.EmailSenderService;
import com.notification.springboot.sending.app.service.SmsSenderService;

@Component

public class Receiver {

	@Autowired
	private EmailSenderService emailService;


	@Autowired
	private SmsSenderService smsService;

	@RabbitListener(autoStartup = "true", bindings = @QueueBinding(value = @Queue(name = "email"), exchange = @Exchange(name = "notification", type = ExchangeTypes.FANOUT)))
	@RabbitHandler
	public void onMessage(String message) throws Exception {
		System.out.println("Consuming Message - " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		SendEmail sendEmail = objectMapper.readValue(message, SendEmail.class);
		emailService.sendEmail(sendEmail);
		System.out.println("String instance " + sendEmail.toString() + " [x] Received");
		

	}

	
	@RabbitListener(autoStartup = "true", bindings = @QueueBinding(value = @Queue(name = "sms"), exchange = @Exchange(name = "notification2", type = ExchangeTypes.FANOUT)))
	@RabbitHandler
	public void onSMS(String message) throws Exception {
		System.out.println("Consuming Message - " + message);
		ObjectMapper objectMapper = new ObjectMapper();
		SendSms sendSms = objectMapper.readValue(message, SendSms.class);
		smsService.sendSms(sendSms);
		System.out.println("String instance " + sendSms.toString() + " [x] Received");

	}

}
