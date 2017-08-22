package com.gojek.parkinglot;

/**
 * Created by Ashish Payal on 22/08/17.
 */
class Car {
	private String registrationNumber;
	private String color;
	
	Car(final String registrationNumber, final String color) {
		this.registrationNumber = registrationNumber;
		this.color = color;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public String getColor() {
		return color;
	}
}
