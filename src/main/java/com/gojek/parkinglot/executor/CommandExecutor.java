package com.gojek.parkinglot.executor;

import static com.gojek.parkinglot.Constants.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.processor.CarRegNumberWithColor;
import com.gojek.parkinglot.processor.LeaveProcessor;
import com.gojek.parkinglot.processor.ParkVehicle;
import com.gojek.parkinglot.processor.ParkingLot;
import com.gojek.parkinglot.processor.SlotNumberWithColor;
import com.gojek.parkinglot.processor.SlotNumberWithRegNumber;
import com.gojek.parkinglot.processor.StatusProcessor;

/**
 * Created by Ashish Payal on 22/08/17.
 */
public class CommandExecutor {
	
	IProcessor processor;
	ParkingLot parking;

	/**
	 * @param command
	 */
	public void execute(String command) {

		String[] commandTkn = command.split(" ");
		List<String> commandList = Arrays.asList(commandTkn);
		String action = commandTkn[0];
		switch(commandTkn.length){
		case 1:
			
			if(action.equals(STATUS)){
				processor = new StatusProcessor();
			}
			processor.process(parking,commandList);
			break;
			
		case 2:
			
			if(action.equals(CREATE_PARKING_LOT)){
				parking = new ParkingLot(Integer.parseInt(commandList.get(1)));
				System.out.println("Created a parking lot with "+ commandList.get(1) + " slots");
				break;
			}
			else if(action.equals(LEAVE)){
				processor = new LeaveProcessor();
				
			}else if(action.equals(REG_NUMBER_FOR_CARS_WITH_COLOR)){
				processor = new CarRegNumberWithColor();
				
			}else if(action.equals(SLOTS_NUMBER_FOR_CARS_WITH_COLOR)){
				
				processor = new SlotNumberWithColor();
				
			}else if(action.equals(SLOTS_NUMBER_FOR_REG_NUMBER)){
				
				processor = new SlotNumberWithRegNumber();
				
			}
			processor.process(parking,commandList);
			break;
		case 3:
			if(action.equals(PARK)){
				
				processor = new ParkVehicle();
				processor.process(parking,commandList);
			}
			break;
			
		default:
			System.out.println("Invalid Input");
			break;
			
		}
		
	}

}
