package uk.ac.ucl.car_rent_system.module.Interface;

public interface Car {

	String getRegistrationNum();
	
	int getTankCapacity();
	
	int getFuel();
	
	boolean fuelFull();
	
	int addFuel(int fuel);
	
	int consumeFuel(int km);	
}
