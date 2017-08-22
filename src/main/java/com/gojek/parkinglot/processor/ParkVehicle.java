package com.gojek.parkinglot.processor;

import java.util.List;
import java.util.Optional;

import com.gojek.parkinglot.executor.IProcessor;
import com.gojek.parkinglot.model.Car;

/**
 * @author Ashish_Payal
 *
 */
public class ParkVehicle implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {

		String regNum = commandList.get(1);
		String color = commandList.get(2);
		Optional<Integer> slot = parking.park(new Car(regNum,color));
		if(slot.isPresent()){
			System.out.println("Allocated slot number: "+slot.get());
		}else{
			System.out.println("Sorry, parking lot is full");
		}
		
	}

}
