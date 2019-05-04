package com.ea.digital.carshow.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

import com.ea.digital.carshow.service.CarShowService;

public class CarShowControllerTest
{
	@Mock
	private CarShowService carShowService;
	
	@InjectMocks 
	private CarShowController carShowController;
	
	@Before
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void getCarsShowTest() {
		when(carShowService.getCarsShow()).thenReturn("<html> George Motors	George 15	Melbourne Car Show </html>");
		String response = carShowController.getCarsShow();
        assertEquals("<html> George Motors	George 15	Melbourne Car Show </html>", response);
	}
}