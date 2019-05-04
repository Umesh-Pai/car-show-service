package com.ea.digital.carshow.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Show implements Serializable {
    
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("cars")
	private List<Car> cars = new ArrayList<Car>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString()
	{
		return "Show{" +
				"name=" + name +
				", cars=" + cars +
				"}";
	}
}
