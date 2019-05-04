package com.ea.digital.carshow.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.ea.digital.carshow.domain.Show;

public class IntegrationUtilsTest {
	
	@Mock
	private RestTemplate restTemplate;
		
	@InjectMocks 
	private IntegrationUtils integrationUtils = new IntegrationUtils();
	
    @Autowired 
    ReflectionTestUtils mReflectionTestUtils;
	
	@Before
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void getCarsShowTestSuccess() throws Exception {
		String uri = "http://eacodingtest.digital.energyaustralia.com.au/api/v1/cars";
        ReflectionTestUtils.setField(integrationUtils, "uri", uri, String.class);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		
		when(restTemplate.exchange(uri, GET, requestEntity, Show[].class)).thenReturn(populateRequestEntity());				
		Show[] showArr = integrationUtils.getCarsShow();
		
		assertNotNull(showArr);
		assertEquals(1, showArr.length);
	}
	
	private ResponseEntity<Show[]> populateRequestEntity () {
		Show[] showArr = new Show[1];
		Show show = new Show();
		show.setName("Melbourne Motor Show");
		showArr[0] = show;
		
		HttpStatus status = HttpStatus.OK;
		ResponseEntity<Show[]> response = new ResponseEntity<Show[]>(showArr, status);
		return response;
	}
}
