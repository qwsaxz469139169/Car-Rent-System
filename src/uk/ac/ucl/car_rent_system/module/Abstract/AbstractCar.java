package uk.ac.ucl.car_rent_system.module.Abstract;

import uk.ac.ucl.car_rent_system.module.Interface.Car;

public abstract class AbstractCar implements Car {
	
	private String registrationNum;
	private boolean canDrive;
	private int tankCapacity;
	private int fuel;

	@Override
	public String getRegistrationNum() {
		// TODO Auto-generated method stub
		return this.registrationNum;
	}

	@Override
	public int getTankCapacity(){
		// TODO Auto-generated method stub
		return this.tankCapacity;
	}

	@Override
	public int getFuel() {
		// TODO Auto-generated method stub
		return this.fuel;
	}

	@Override
	public boolean fuelFull() {
		boolean fuelFull = false;
		
		if(this.getFuel()==this.getTankCapacity()){
			fuelFull=true;
		}
		
		return fuelFull;
	}

	@Override
	public int addFuel(int fuel) {
		// TODO Auto-generated method stub
		int curFuel = this.getFuel();
		
		curFuel = curFuel + fuel;
		
		if (curFuel > this.getTankCapacity()) {
			curFuel = this.getTankCapacity();
		}
		
		return curFuel;
	}

	@Override
	public int consumeFuel(int km) {
		// TODO Auto-generated method stub
		return 0;
	}
	 

}
