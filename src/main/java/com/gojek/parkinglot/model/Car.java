package com.gojek.parkinglot.model;

/**
 * @author Ashish_Payal
 *
 */
public class Car {
	private String registrationNumber;
	private String color;
	
	/**
	 * @param registrationNumber
	 * @param color
	 */
	public Car(final String registrationNumber, final String color) {
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
