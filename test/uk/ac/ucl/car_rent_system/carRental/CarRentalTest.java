package uk.ac.ucl.car_rent_system.carRental;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;


import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.module.person.DrivingLicense;
import uk.ac.ucl.car_rent_system.module.person.Name;
import uk.ac.ucl.car_rent_system.module.person.Person;

public class CarRentalTest {
	
	Rental rent;
	
	List<Car> largeCars;
	
	List<Car> smallCars;

	List<Car> rentCars;
	
	Person person;
	
	DrivingLicense drivingLicense;

	
	@Before
	public void setUp(){
		rent = new CarRental();
		
        Calendar tempDate = Calendar.getInstance();
        tempDate.set(1996, 5, 9);
        
        Name name = new Name("Yuchen","Guo");

        person = new Person(name, tempDate.getTime());

        tempDate.set(2016, 5, 10);
        Date issueDate = tempDate.getTime();
        
        drivingLicense = DrivingLicense.getInstance(person, issueDate, true);
	}

	@Test
	public void testAvailableCars() {
		int availableCars = rent.availableCars("small");
		assertEquals(20,availableCars);
	}

	@Test
	public void testGetRentedCars() {
		List<Car> rentedCars = rent.getRentedCars();
		int num = rentedCars.size();
		assertEquals(0,num);
	}

	@Test
	public void testGetCar() {
		Car car = rent.getCar(person);
		assertEquals(null,car);
	}

	@Test
	public void testIssueCar() {
		rent.issueCar(person, drivingLicense, "small");
		int availableCars = rent.availableCars("small");
		assertEquals(19,availableCars);
	}

	@Test
	public void testTerminateRental() {
		rent.terminateRental(person);
		int availableCars = rent.availableCars("small");
		assertEquals(20,availableCars);	
	}

}
