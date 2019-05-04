package com.ea.digital.carshow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ea.digital.carshow.domain.Car;
import com.ea.digital.carshow.domain.Show;
import com.ea.digital.carshow.service.CarShowService;
import com.ea.digital.carshow.util.IntegrationUtils;
import com.ea.digital.carshow.util.MakeComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CarShowServiceImpl implements CarShowService {
	
	@Autowired
	private IntegrationUtils integrationUtils;
	
	public String getCarsShow() {
		List<Car> carList = new ArrayList<Car>();
		
		try {
			Show[] showArray = integrationUtils.getCarsShow();			
			if (showArray == null || showArray.length == 0) {
				return "<html> <b>Oops! Something went wrong. Please try again after some time. </b></html>";
			} else {
				List<Show> showList = Arrays.asList(showArray);
				for(Show show : showList){	
					for(Car car : show.getCars()){
						car.setShowName(show.getName());
						carList.add(car);
					}
				}
				
				Collections.sort(carList, new MakeComparator());
				return formHtmlString(carList).toString();
			}
		} catch (Exception e) {
			System.out.println("Exception occured!!!" + e.getMessage());
			return "<html> <b>Oops! Something went wrong. Please try again after some time. </b></html>";
		}
	}
	
	private StringBuilder formHtmlString(List<Car> carList) {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		for(Car car : carList){
			sb.append(car.getMake() + "<br/> &emsp;&emsp;" + car.getModel() + "<br/> &emsp;&emsp;&emsp;&emsp;" + car.getShowName() + "<p>");
		}
		sb.append("</html>");
		return sb;
	}
}
	