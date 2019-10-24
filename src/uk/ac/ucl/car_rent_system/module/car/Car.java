package uk.ac.ucl.car_rent_system.module.car;

public interface Car {

	RegistrationNum getRegistrationNum();
	
	int getTankCapacity();
	
	int getFuel();
	
	String getCarType();	
	
	void setRent(boolean isRent);
	
	boolean fuelFull();
	
	int addFuel(int litre);
	
	int driveCar(int kilometer);
		
	RegistrationNum createRegistrationNum();
}
