package com.ea.digital.carshow.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ea.digital.carshow.domain.Car;
import com.ea.digital.carshow.domain.Show;
import com.ea.digital.carshow.service.CarShowService;
import com.ea.digital.carshow.util.IntegrationUtils;

public class CarShowServiceImplTest {
	
	@Mock
	private IntegrationUtils integrationUtils;
	
	@InjectMocks 
	private CarShowService carShowService = new CarShowServiceImpl();
	
	@Before
	public void initMocks()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test 
	public void getCarsShowTestSuccess() {
		when(integrationUtils.getCarsShow()).thenReturn(populateShowDetails());
		String response = carShowService.getCarsShow();
        assertEquals("<html>George Motors<br/> &emsp;&emsp;George 15<br/> &emsp;&emsp;&emsp;&emsp;Melbourne Motor Show<p></html>", response);
	}
	
	@Test 
	public void getCarsShowTestFailure() {
		when(integrationUtils.getCarsShow()).thenReturn(populateShowDetailsEmpty());
		String response = carShowService.getCarsShow();
        assertEquals("<html> <b>Oops! Something went wrong. Please try again after some time. </b></html>", response);
	}
	
	private Show[] populateShowDetails () {
		Show[] showArr = new Show[1];
		
		List<Car> cars = new ArrayList<Car>();
		Car car = new Car();
		car.setMake("George Motors"); car.setModel("George 15");
		cars.add(car);
		
		Show show = new Show();
		show.setCars(cars);
		show.setName("Melbourne Motor Show");
		
		showArr[0] = show;
		return showArr;
	}
	
	private Show[] populateShowDetailsEmpty() {
		Show[] showArr = new Show[0];
		return showArr;
	}

	
}
	