package com.gojek.parkinglot;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


/**
 * Created by Ashish Payal on 22/08/17.
 */
class ParkingLot {
	private ParkingLot instance;
	
	private Car[] parkingSlots;
	private Queue<Integer> ticketingMachine;
	
	private ParkingLot(final int size) {
		this.parkingSlots = new Car[size];
		this.ticketingMachine = new PriorityQueue<Integer>();
	}
	
	String park(Car car) {
		return null;
	}
	
	Car leave(int slotNumber) {
		return null;
	}
	
	Map<Integer, Car> status() {
		return null;
	}
	
	List<Car> getCarsByColor(String color) {
		return null;
	}
	
	List<Integer> getSlotsByColor(String color) {
		return null;
	}
	
	List<Integer> getSlotsByRegNo(String regNumber) {
		return null;
	}
}
