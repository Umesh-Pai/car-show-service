package com.ea.digital.carshow.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanFactoryConfiguration {	
	
	@Bean
    public RestTemplate serviceFactory() {
        return new RestTemplate();
    }
}
