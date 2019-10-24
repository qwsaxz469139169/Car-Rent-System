package uk.ac.ucl.car_rent_system.carRental;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.ac.ucl.car_rent_system.module.car.AbstractCar;
import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.module.person.DrivingLicense;
import uk.ac.ucl.car_rent_system.module.person.Person;
import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class CarRental implements Rental{
	
	private static List<Car> largeCars = AbstractCar.getInstances("large", 10);
	private static List<Car> smallCars = AbstractCar.getInstances("small", 20);
	
	private static List<Car> rentCars = new ArrayList();
	
    /***
     * returns the number of cars of the specified type that are available to rent
     * @return int Object
     */
	public int availableCars(String type) {
		if(type.equals("large")){
			return largeCars.size();
		}else if(type.equals("small")){
			return smallCars.size();
		}else{
			throw new IllegalArgumentException("There is not this type.");
		}
	}

    /***
     * returns a collection of all the cars currently rented out (if any).
     * @return List<Car> Object:
     */
	public List<Car> getRentedCars() {
		return rentCars;

	}

    /***
     * Get a car that given person rent
     * @param Person Object
     * @return Car Object
     */
	public Car getCar(Person person) {
       if(person!=null){
    	   return person.getCar();
       }else{
    	   throw new IllegalArgumentException("Parameters are missing!");
       }
	}

    /***
     * issue car
     * @param Person Object: renter
     * @param DrivingLicense Object: the driving license of the renter
     * @param String Object: the type of car that the renter need
     */
	public void issueCar(Person person, DrivingLicense drivingLicense, String type) {
		if(person==null||drivingLicense==null||SystemTool.isEmpty(type)){
			throw new IllegalArgumentException("Parameters are missing!");
		}
		
		if (checkCanRent(person, drivingLicense, type)) {
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
			
			rentCars.add(car);
		} else {
			throw new IllegalArgumentException("Sorry! The car cannot be issued.");
		}
	}
	
    /***
     * check whether the renter can rent car or not
     * @param Person Object: renter
     * @param DrivingLicense Object: the driving license of the renter
     * @param String Object: the type of car that the renter need
     */
	private boolean checkCanRent(Person person, DrivingLicense drivingLicense, String type) {
		// TODO Auto-generated method stub
		boolean result = true;

		if (person.getCar() != null) {
			result = false;
		} else if (!drivingLicense.isFullLicense()) {
			result = false;
		}

		if (type.equals("large")) {
			if (largeCars.size() == 0) {
				result = false;
			} else if (drivingLicense.getIssueDatetoNow() < 5) {
				result = false;
			} else if (person.getAge() < 25) {
				result = false;
			}
		} else if (type.equals("small")) {
			if (smallCars.size() == 0) {
				result = false;
			} else if (drivingLicense.getIssueDatetoNow() < 1) {
				result = false;
			} else if (person.getAge() < 20) {
				result = false;
			}
		} else {
			throw new IllegalArgumentException("There is not this type.");
		}

		return result;
	}

    /***
     * terminates the given person's rental contract
     * @param Person Object: renter
     */
	public void terminateRental(Person person) {
		if (person == null) {
			throw new IllegalArgumentException("Parameters are missing!");
		}
		
		Car car = person.getCar();

		if (car != null) {
			String carType = car.getCarType();

			if(!car.fuelFull()){
				int fuel = car.getFuel();
				car.addFuel(car.getTankCapacity() - fuel);
			}

			car.setRent(false);

			if (carType.equals("large")) {
				largeCars.add(car);
			} else if (carType.equals("small")) {
				smallCars.add(car);
			}
            
			for (int i = 0; i < rentCars.size(); i++) {
				if(rentCars.get(i)==car){
					rentCars.remove(i);
				}
			}
			
			person.setCar(null);
		}
	}
}
