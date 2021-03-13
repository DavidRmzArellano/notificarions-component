package com.notification.springboot.sending.app;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SendingNotificationsApplication implements CommandLineRunner {
	
	private static final Logger log = org.slf4j.LoggerFactory.getLogger(SendingNotificationsApplication.class);

	@Value(value = "${mimerkadito.value}")
	String n;
	public static void main(String[] args) {
		SpringApplication.run(SendingNotificationsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		log.info(n);
	}

}
