package com.ea.digital.carshow.util;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.ea.digital.carshow.domain.Show;

@Component
public class IntegrationUtils
{
	
	@Value("${cars.service.uri}")
	private String uri;
	
	@Autowired
	private RestTemplate restTemplate;
		
	public Show[] getCarsShow() {
		Show[] show = null;
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		try {
			ResponseEntity<Show[]> responseEntity = restTemplate.exchange(uri, GET, requestEntity, Show[].class);
			show = responseEntity.getBody();
		} catch (Exception e) {
			System.out.println("Exception occured while connecting to backend system::" + e.getMessage());
		}
		
		return show;
	}
}
