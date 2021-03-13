package com.notification.springboot.sending.app.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {
	
	/*
	
	@Bean
	public FanoutExchange notificationExchange() {
		return new FanoutExchange("notification", false, false);
	}
	
	@Bean
	public Queue queueEmail() {
		return new Queue("email",false,false , false);
	}
	
	@Bean
	public Binding notificationBinding() {
		return BindingBuilder.bind(queueEmail()).to(notificationExchange());
	}
	*/
	
}
