package uk.ac.ucl.car_rent_system.module.car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractCar implements Car {
	
	private RegistrationNum registrationNum;
	
	private boolean isRent = false;
	
	private int tankCapacity;
	
	private int fuel = 0;
	
	private String carType;
		
	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

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

	public void setRegistrationNum(RegistrationNum registrationNum) {
		this.registrationNum = registrationNum;
	}

	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public void setFuel(int fuel) {
		this.fuel = fuel;
	}	

	public boolean isRent() {
		return isRent;
	}

	public void setRent(boolean isRent) {
		this.isRent = isRent;
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
	public int addFuel(int litre) {
		// TODO Auto-generated method stub
		if (litre < 0) {
			litre = 0;
		}
		
		int curFuel = this.fuel;
		
		curFuel = curFuel + litre;
		
		if (curFuel > this.tankCapacity) {
			curFuel = this.tankCapacity;
		}
		
		return curFuel;
	}

	 
	public static Car getInstance(String type){
		if(type.equals("large")){
			return new LargeCar();
		}else if(type.equals("small")){
			return new SmallCar();
		}else{
			throw new IllegalArgumentException("There are not this type.");
		}
	}
	
	public static List<Car> getInstances(String type, int num) {
		List<Car> result = new ArrayList<>();

		Car carInstance = null;
		
		if (type.equals("large") && num > 0) {
			for (int i = 0; i < num; i++) {
				carInstance = new LargeCar();
				result.add(carInstance);
			}
		} else if (type.equals("small") && num > 0) {
			for (int i = 0; i < num; i++) {
				carInstance = new SmallCar();
				result.add(carInstance);
			}
		} else {
			throw new IllegalArgumentException("There are not this type or num < 0.");
		}

		return result;
	}

}
