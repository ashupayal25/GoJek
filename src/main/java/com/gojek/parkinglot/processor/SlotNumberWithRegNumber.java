package com.gojek.parkinglot.processor;

import java.util.List;

import com.gojek.parkinglot.executor.IProcessor;

/**
 * @author Ashish_Payal
 *
 */
public class SlotNumberWithRegNumber implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {

		String regNumber = commandList.get(1);
		List<Integer> slots = parking.getSlotsByRegNo(regNumber);
		if(slots.isEmpty()){
			System.out.println("Not Found");
		}else{
			StringBuilder sb = new StringBuilder();
			String delim = "";
			for (Integer i : slots) {
			    sb.append(delim).append(i);
			    delim = ",";
			}
			System.out.println(sb);
		}
	}

}
