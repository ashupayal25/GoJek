package com.gojek.parkinglot.executor;

import java.util.List;

import com.gojek.parkinglot.processor.ParkingLot;

/**
 * @author Ashish_Payal
 *
 */
public interface IProcessor {

	
	/**
	 * @param parkingLot
	 * @param commandList
	 */
	void process(ParkingLot parkingLot,List<String> commandList);
	
}
