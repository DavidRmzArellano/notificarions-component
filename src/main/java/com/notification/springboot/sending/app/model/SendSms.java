package com.notification.springboot.sending.app.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendSms {
	 private String para;
	 private Map<String, Object> map;
}
