package com.ea.digital.carshow.domain;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Car implements Serializable {
    
	@JsonProperty("make")
    private String make;

	@JsonProperty("model")
    private String model;
	
	private String showName;
	
	public String getShowName() {
		if (showName != null && showName != "") {
			return showName;
		} else {
			return "NA";
		}
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getMake() {
		if (make != null && make != "") {
			return make;
		} else {
			return "NA";
		}
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		if (model != null && model != "") {
			return model;
		} else {
			return "NA";
		}
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString()
	{
		return "Car{" +
				"make=" + make +
				", model=" + model + 
				", show=" + showName + 
				"}";
	}

}
