package com.gojek.parkinglot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;



/**
 * Created by Ashish Payal on 22/08/17.
 */
class ParkingLot {
	private ParkingLot instance;
	
	private Car[] parkingSlots;
	private Queue<Integer> ticketingMachine;
	
	ParkingLot(final int size) {
		this.parkingSlots = new Car[size];
		this.ticketingMachine = new PriorityQueue<Integer>();
		for (int i=1; i<= size; i++) {
            ticketingMachine.offer(i);
        }
	}
	
	Optional<Integer> park(Car car) {
		if(car==null)
			return Optional.empty();
		if(!ticketingMachine.isEmpty()){
			int emptySlot = ticketingMachine.poll();
			parkingSlots[emptySlot-1] = car;
			return Optional.of(emptySlot);
		}

		return Optional.empty();
	}
	
	Optional<Car> leave(int slotNumber) {
		if(parkingSlots[slotNumber-1]!=null){
			Car car = parkingSlots[slotNumber-1];
			parkingSlots[slotNumber-1] = null;
			ticketingMachine.offer(slotNumber);
			return Optional.of(car);
		}
		return Optional.empty();
	}
	
	Map<Integer, Car> status() {
		Map<Integer,Car> statusMap = new HashMap<Integer, Car>();
		for (int i = 0; i < parkingSlots.length; i++) {
			if(parkingSlots[i]!=null){
				statusMap.put(i,parkingSlots[i]);
			}
		}
		return statusMap;
	}
	
	List<Car> getCarsByColor(String color) {
		return Arrays.stream(parkingSlots).parallel()
			.filter(car -> car != null  && StringUtils.equalsIgnoreCase(car.getColor(), color))
			.collect(Collectors.toList());
	}
	
	List<Integer> getSlotsByColor(String color) {
		List<Integer> carList= new ArrayList<Integer>();
		for (int i = 0; i < parkingSlots.length; i++) {
			if(parkingSlots[i]!=null){
				Car car = parkingSlots[i];
				if(car.getColor().equalsIgnoreCase(color)){
					carList.add(i);
				}
			}
		}
		return carList;
	}
	
	List<Integer> getSlotsByRegNo(String regNumber) {
		List<Integer> carList= new ArrayList<Integer>();
		for (int i = 0; i < parkingSlots.length; i++) {
			if(parkingSlots[i]!=null){
				
				Car car = parkingSlots[i];
				if(car.getRegistrationNumber().equalsIgnoreCase(regNumber)){
					carList.add(i);
				}
			}
		}
		return carList;
	}
}
