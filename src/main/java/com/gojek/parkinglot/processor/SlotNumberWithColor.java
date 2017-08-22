package com.gojek.parkinglot.processor;

import java.util.List;

import com.gojek.parkinglot.executor.IProcessor;

/**
 * @author Ashish_Payal
 *
 */
public class SlotNumberWithColor implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {

		String color  = commandList.get(1);
		List<Integer> slots = parking.getSlotsByColor(color);
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
