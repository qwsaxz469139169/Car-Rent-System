package uk.ac.ucl.car_rent_system.module.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import uk.ac.ucl.car_rent_system.module.car.AbstractCar;
import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.module.person.DrivingLicence;
import uk.ac.ucl.car_rent_system.module.person.Person;

public class CarRent {
	
	private static Map<String,Car> largeCars = AbstractCar.getInstances("large", 10);
	private static Map<String,Car> smallCars = AbstractCar.getInstances("small", 20);
	
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
    	   throw new IllegalArgumentException("Params is null");
       }
	}

	public void issueCar(Person person,DrivingLicence drivingLicence,String type) {
       if(checkPerson(person,drivingLicence)&&checkCar(type,drivingLicence)){
    	   
       }
	}
	
	private boolean checkCar(String type, DrivingLicence drivingLicence) {
		// TODO Auto-generated method stub
		boolean result = true;

		return result;
	}

	private boolean checkPerson(Person person, DrivingLicence drivingLicence) {
		// TODO Auto-generated method stub
		boolean result = true;
		
		if(person.getCar()!=null){
			result = false;
		}else if(!drivingLicence.isFullLicense()){
			result = false;
		}
		
		return result;
	}

	public void terminateRental(Person person){
		
	}
}
