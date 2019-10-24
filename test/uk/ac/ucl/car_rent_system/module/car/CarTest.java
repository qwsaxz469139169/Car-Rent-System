package uk.ac.ucl.car_rent_system.module.car;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CarTest {
	Car largeCar;
	Car smallCar;
	List<Car> cars;
	
	@Before
	public void setUp(){
		largeCar = new LargeCar();
		smallCar = new SmallCar();
		
		largeCar.setRent(true);
		smallCar.setRent(true);
						
	}
		
	@Test
	public void testGetTankCapacity() {
		assertEquals(60, largeCar.getTankCapacity());
	}

	@Test
	public void testGetFuel() {
		assertEquals(60,largeCar.getFuel());
	}

	@Test
	public void testFuelFull() {
		assertEquals(true,smallCar.fuelFull());
	}

	@Test
	public void testAddFuel() {
		assertEquals(60,largeCar.addFuel(80));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInstance() {
		AbstractCar.getInstance("dd");
	}
	
	@Test
	public void testGetInstances() {
		cars = AbstractCar.getInstances("large", 10);
		int num = cars.size();
		assertEquals(10,num);
	}
	
	@Test
	public void testLargeDriveCar() {
		int num = largeCar.driveCar(70);
		assertEquals(7,num);
	}
	
	@Test
	public void testSmallDriveCar() {
		int num = smallCar.driveCar(70);
		assertEquals(4,num);
	}	
	
}
