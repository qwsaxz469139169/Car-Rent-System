package uk.ac.ucl.car_rent_system.carRental;

import java.util.List;

import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.module.person.DrivingLicense;
import uk.ac.ucl.car_rent_system.module.person.Person;

public interface Rental{
	
	int availableCars(String type);
	
	List<Car> getRentedCars();
	
	Car getCar(Person person);
	
	void issueCar(Person person, DrivingLicense drivingLicense, String type);
	
	void terminateRental(Person person);
	
}
