package com.gojek.parkinglot.processor;

import static com.gojek.parkinglot.Constants.Constants.END_OF_LINE;
import static com.gojek.parkinglot.Constants.Constants.SEPARATOR;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.gojek.parkinglot.executor.IProcessor;
import com.gojek.parkinglot.model.Car;

/**
 * @author Ashish_Payal
 *
 */
public class StatusProcessor implements IProcessor {

	@Override
	public void process(ParkingLot parking,List<String> commandList) {
		Map<Integer, Car> map = parking.getStatus();
		if(!map.isEmpty()){
			 StringBuilder sb = new StringBuilder();
			 sb.append("Slot No."+SEPARATOR+"Registration No"+SEPARATOR+"Colour");
			 for(Entry<Integer, Car> entry: map.entrySet()){
				 Integer slot = entry.getKey()+1;
				 Car car  = entry.getValue();
				 sb.append(END_OF_LINE);
				 sb.append(slot+SEPARATOR);
				 sb.append(car.getRegistrationNumber()+SEPARATOR);
				 sb.append(car.getColor());
				 
			 }
			 System.out.println(sb);
			 
		}
	}

}
