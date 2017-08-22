package com.gojek.parkinglot;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gojek.parkinglot.model.Car;
import com.gojek.parkinglot.processor.ParkingLot;

/**
 * Created by Ashish Payal on 22/08/17.
 */
public class ParkingLotTest {
	private static final int SIZE = 6;
	
	
	ParkingLot instance;
	
	@BeforeMethod
	public void init() {
		instance = new ParkingLot(SIZE);
	}
	
	@DataProvider(name="parkDP")
	String[][] parkDP() {
		return new String[][] {
			{"KA-01-HH-1234", "White"}
		};
	}
	
	@Test(dataProvider="parkDP")
	public void testParkingCapacity(final String regNumber, final String color) {
		for(int i = 0; i < SIZE; i++) {
			Optional<Integer> slot = instance.park(new Car(regNumber,color));
			Assert.assertTrue(slot.isPresent());
		}
		
		Assert.assertFalse(instance.park(new Car(regNumber,color)).isPresent());
		
		instance.leave(1);
		
		Assert.assertTrue(instance.park(new Car(regNumber, color)).isPresent());
		
		Assert.assertFalse(instance.park(new Car(regNumber, color)).isPresent());
	}

	@Test(dataProvider="parkDP")
	public void testSlotEmpty(final String regNumber, final String color) {
		instance.park(new Car(regNumber,color));
		
		Optional<Car> car = instance.leave(1);
		Assert.assertTrue(car.isPresent());
		
		car = instance.leave(1);
		Assert.assertFalse(car.isPresent());
 	}
	
	@Test(dataProvider="parkDP")
	public void testStatus(final String regNumber, final String color){
		
		for(int i = 0; i < SIZE-1; i++) {
			Optional<Integer> slot = instance.park(new Car(regNumber,color));
			Assert.assertTrue(slot.isPresent());
		}
		
		Map<Integer, Car> carList = instance.getStatus();	
		Assert.assertEquals(carList.size(), SIZE-1);
	
		instance.park(new Car(regNumber,color));
		instance.park(new Car(regNumber,color));
		
		carList = instance.getStatus();	
		Assert.assertEquals(carList.size(), SIZE);
		
	}
	
	@Test(dataProvider="parkDP")
	public void testGetCarsByColor(final String regNumber, final String color){
		
		List<Car> car = instance.getCarsByColor("White");
		Assert.assertEquals(car.size(), 0);
		
		instance.park(new Car(regNumber,color));
		
		car = instance.getCarsByColor("White");
		Assert.assertEquals(car.size(), 1);
	}
	
	@Test(dataProvider="parkDP")
	public void testGetSlotsByColor(final String regNumber, final String color){
		
		List<Integer> slots = instance.getSlotsByColor("White");
		Assert.assertEquals(slots.size(), 0);
	
		instance.park(new Car(regNumber,color));
		
		slots = instance.getSlotsByColor("White");
		Assert.assertEquals(slots.size(), 1);
		
	}
	
	@Test(dataProvider="parkDP")
	public void testGetSlotsByRegNo(final String regNumber, final String color){
		List<Integer> slots = instance.getSlotsByRegNo("KA-01-HH-1234");
		Assert.assertEquals(slots.size(), 0);
	
		instance.park(new Car(regNumber,color));
		
		slots = instance.getSlotsByRegNo("KA-01-HH-1234");
		Assert.assertEquals(slots.size(), 1);
		
	}
}
