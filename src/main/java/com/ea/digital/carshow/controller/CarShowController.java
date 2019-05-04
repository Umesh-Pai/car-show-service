package com.ea.digital.carshow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ea.digital.carshow.service.CarShowService;

@RestController
public class CarShowController {
	
	@Autowired
	private CarShowService carShowService;
	
	@CrossOrigin
	@RequestMapping(value = "/api/v1/cars/show", method = RequestMethod.GET)
	public String getCarsShow()
	{	
		return carShowService.getCarsShow();
	}	
}
