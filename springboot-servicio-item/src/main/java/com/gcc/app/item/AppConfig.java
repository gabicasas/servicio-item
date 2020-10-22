package com.gcc.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	@Bean("clientRestTemplate")
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
