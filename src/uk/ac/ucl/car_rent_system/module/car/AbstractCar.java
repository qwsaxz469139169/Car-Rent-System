package uk.ac.ucl.car_rent_system.module.car;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCar implements Car {
	
	private RegistrationNum registrationNum;
	
	private boolean canDrive;
	
	private boolean isRent = false;
	
	private int tankCapacity;
	
	private int fuel = 0;
		
	@Override
	public RegistrationNum getRegistrationNum() {
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
	
	

	public boolean isCanDrive() {
		return canDrive;
	}

	public void setCanDrive(boolean canDrive) {
		this.canDrive = canDrive;
	}

	public void setRegistrationNum(RegistrationNum registrationNum) {
		this.registrationNum = registrationNum;
	}

	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}

	@Override
	public boolean fuelFull() {
		boolean fuelFull = false;
		
		if(this.fuel==this.tankCapacity){
			fuelFull=true;
		}
		
		return fuelFull;
	}

	@Override
	public int addFuel(int fuel) {
		// TODO Auto-generated method stub
		if (fuel < 0) {
			fuel = 0;
		}
		
		int curFuel = this.fuel;
		
		curFuel = curFuel + fuel;
		
		if (curFuel > this.tankCapacity) {
			curFuel = this.tankCapacity;
		}
		
		return curFuel;
	}

	 
	public static Car getInstance(String car){
		if(car.equals("large")){
			return new LargeCar();
		}else if(car.equals("small")){
			return new SmallCar();
		}else{
			throw new IllegalArgumentException("There are not this type.");
		}
	}
	
	public static Map<String, Car> getInstances(String car, int num) {
		Map<String, Car> result = new HashMap();

		Car carInstance = null;
		String rm = "";
		if (car.equals("large") && num > 0) {
			for (int i = 0; i < num; i++) {
				carInstance = new LargeCar();

				rm = carInstance.getRegistrationNum().toString();

				result.put(rm, carInstance);
			}
		} else if (car.equals("small") && num > 0) {
			for (int i = 0; i < num; i++) {
				carInstance = new SmallCar();
				rm = carInstance.getRegistrationNum().toString();
				result.put(rm, carInstance);
			}
		} else {
			throw new IllegalArgumentException("There are not this type or num < 0.");
		}

		return result;
	}

}
