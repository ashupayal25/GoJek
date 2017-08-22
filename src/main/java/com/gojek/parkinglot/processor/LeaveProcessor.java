package com.gojek.parkinglot.processor;

import java.util.List;
import java.util.Optional;

import com.gojek.parkinglot.executor.IProcessor;
import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.processor.ParkingLot;

/**
 * @author Ashish_Payal
 *
 */
public class LeaveProcessor implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {

		Optional<Car> output = parking.leave(Integer.parseInt(commandList.get(1)));
		
		if(!output.isPresent()){
			System.out.println("Slot is already free");
		}else{
			System.out.println("Slot number " +commandList.get(1)+ " is free");
		}
	}
	
}
