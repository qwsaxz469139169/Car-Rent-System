package uk.ac.ucl.car_rent_system.carRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.ac.ucl.car_rent_system.module.car.AbstractCar;
import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.module.person.DrivingLicence;
import uk.ac.ucl.car_rent_system.module.person.Person;

public class CarRental {
	
	private static List<Car> largeCars = AbstractCar.getInstances("large", 10);
	private static List<Car> smallCars = AbstractCar.getInstances("small", 20);
	
	private static List<Car> rentCars = new ArrayList();
	
	public int availableCars(String type) {
		if(type.equals("large")){
			return largeCars.size();
		}else if(type.equals("small")){
			return smallCars.size();
		}else{
			throw new IllegalArgumentException("There is not this type.");
		}
	}

	public List<Car> getRentedCars() {
		return rentCars;

	}

	public Car getCar(Person person) {
       if(person!=null){
    	   return person.getCar();
       }else{
    	   throw new IllegalArgumentException("Parameters are missing!");
       }
	}

	public void issueCar(Person person, DrivingLicence drivingLicence, String type) {
		if (checkCanRent(person, drivingLicence, type)) {
			Car car = null;

			if (type.equals("large")) {
				car = largeCars.get(0);
				
				person.setCar(car);
				car.setRent(true);
				
				largeCars.remove(0);
			} else if (type.equals("small")) {
				car = smallCars.get(0);
				
				person.setCar(car);
				car.setRent(true);
				
				smallCars.remove(0);
			}
		} else {
			throw new IllegalArgumentException("Sorry! The car cannot be issued.");
		}
	}
	
	private boolean checkCanRent(Person person, DrivingLicence drivingLicence, String type) {
		// TODO Auto-generated method stub
		boolean result = true;

		if (person.getCar() != null) {
			result = false;
		} else if (!drivingLicence.isFullLicense()) {
			result = false;
		}

		if (type.equals("large")) {
			if (largeCars.size() == 0) {
				result = false;
			} else if (drivingLicence.getIssueDatetoNow() < 5) {
				result = false;
			} else if (person.getAge() < 25) {
				result = false;
			}
		} else if (type.equals("small")) {
			if (smallCars.size() == 0) {
				result = false;
			} else if (drivingLicence.getIssueDatetoNow() < 1) {
				result = false;
			} else if (person.getAge() < 20) {
				result = false;
			}
		} else {
			throw new IllegalArgumentException("There is not this type.");
		}

		return result;
	}

	public void terminateRental(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("Parameters are missing!");
		}
		Car car = person.getCar();

		if (car != null) {
			String carType = car.getCarType();

			int fuel = car.getFuel();
			car.addFuel(car.getTankCapacity() - fuel);

			car.setRent(false);

			if (carType.equals("large")) {
				largeCars.add(car);
			} else if (carType.equals("small")) {
				smallCars.add(car);
			}

			person.setCar(null);
		}
	}
}
