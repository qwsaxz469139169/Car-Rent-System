package uk.ac.ucl.car_rent_system.module.car;

public interface Car {

	RegistrationNum getRegistrationNum();
	
	int getTankCapacity();
	
	int getFuel();
	
	boolean fuelFull();
	
	int addFuel(int fuel);
	
	int consumeFuel(int km);
		
	RegistrationNum createRegistrationNum();
}
