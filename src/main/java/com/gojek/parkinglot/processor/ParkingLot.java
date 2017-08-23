package com.gojek.parkinglot.processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.StringUtils;

import com.gojek.parkinglot.model.Car;

/**
 * @author Ashish_Payal
 *
 */
public class ParkingLot {
	
	private static Car[] parkingSlots;
	private static Queue<Integer> ticketingMachine;
	
	/**
	 * @param size
	 */
	public ParkingLot(final int size) {
		this.parkingSlots = new Car[size];
		this.ticketingMachine = new PriorityQueue<Integer>();
		for (int i=1; i<= size; i++) {
            ticketingMachine.offer(i);
        }
	}

	/**
	 * @param car
	 * @return Integer - slot number where the car has been parked
	 */
	public Optional<Integer> park(Car car) {
		if(car==null)
			return Optional.empty();
		if(!ticketingMachine.isEmpty()){
			int emptySlot = ticketingMachine.poll();
			parkingSlots[emptySlot-1] = car;
			return Optional.of(emptySlot);
		}

		return Optional.empty();
	}
	
	/**
	 * @param slotNumber
	 * @return Car object 
	 */
	public Optional<Car> leave(int slotNumber) {
		if(parkingSlots[slotNumber-1]!=null){
			Car car = parkingSlots[slotNumber-1];
			parkingSlots[slotNumber-1] = null;
			ticketingMachine.offer(slotNumber);
			return Optional.of(car);
		}
		return Optional.empty();
	}
	
	/**
	 * @return Return the Map<Integer,Car> where Integer is the slot number and car which is parked on the slot
	 */
	public Map<Integer, Car> getStatus() {
		Map<Integer,Car> statusMap = new HashMap<Integer, Car>();
		for (int i = 0; i < parkingSlots.length; i++) {
			if(parkingSlots[i]!=null){
				statusMap.put(i,parkingSlots[i]);
			}
		}
		return statusMap;
	}
	
	/**
	 * @param color
	 * @return the list of Cars currently in parking with given color
	 */
	public List<Car> getCarsByColor(String color) {
		return Arrays.stream(parkingSlots).parallel()
			.filter(car -> car != null  && StringUtils.equalsIgnoreCase(car.getColor(), color))
			.collect(Collectors.toList());
	}
	
	/**
	 * @param color
	 * @return the List<Integer> i.e., the list of slots with given vehicle color 
	 */
	public List<Integer> getSlotsByColor(String color) {
		return IntStream.range(0, parkingSlots.length).parallel()
				.filter(slotNo -> parkingSlots[slotNo] != null && StringUtils.equalsIgnoreCase(parkingSlots[slotNo].getColor(), color))
				.mapToObj(Integer::new)
				.collect(Collectors.toList());
		
	}
	
	/**
	 * @param regNumber
	 * @return List<integer i.e., the list of slos with given registration Number
	 */
	public List<Integer> getSlotsByRegNo(String regNumber) {
		return IntStream.range(0, parkingSlots.length).parallel()
			.filter(slotNo -> parkingSlots[slotNo] != null && StringUtils.equalsIgnoreCase(parkingSlots[slotNo].getRegistrationNumber(), regNumber))
			.mapToObj(Integer::new)
			.collect(Collectors.toList());
		}
}
