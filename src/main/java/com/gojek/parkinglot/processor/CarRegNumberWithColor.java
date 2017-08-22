package com.gojek.parkinglot.processor;

import java.util.List;

import com.gojek.parkinglot.executor.IProcessor;
import com.gojek.parkinglot.model.Car;

/**
 * @author Ashish_Payal
 *
 */
public class CarRegNumberWithColor implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {
		String color = commandList.get(1);
		List<Car> listOfCars = parking.getCarsByColor(color);
		if(listOfCars.isEmpty()){
			System.out.println("Not Found");
		}else{
			StringBuilder sb = new StringBuilder();
			String delim = "";
			for (Car i : listOfCars) {
			    sb.append(delim).append(i.getRegistrationNumber());
			    delim = ",";
			}
			System.out.println(sb);
		}
		
	}

}
