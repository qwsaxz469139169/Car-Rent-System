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
		
	/***
     * get type of the car
     * @return String Object
     */
	public String getCarType() {
		return carType;
	}

    /***
     * set type of the car
     * @param String Object: type of the car
     */
	public void setCarType(String carType) {
		this.carType = carType;
	}

    /***
     * get registration number of the car
     * @return RegistrationNum Object
     */
	public RegistrationNum getRegistrationNum() {
		return this.registrationNum;
	}

    /***
     * get the capacity in whole Litres of the car's fuel tank
     * @return int Object: Litres
     */
	public int getTankCapacity(){
		return this.tankCapacity;
	}

    /***
     * get the amount of fuel in whole Litres currently in the fuel tank
     * @return int Object: Litres
     */
	public int getFuel() {
		return this.fuel;
	}

    /***
     * set registration number of the car
     * @param RegistrationNum Object: a registration number
     */
	public void setRegistrationNum(RegistrationNum registrationNum) {
		this.registrationNum = registrationNum;
	}
	
    /***
     * set tank capacity of the car
     * @param int Object: litre
     */
	public void setTankCapacity(int tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

    /***
     * set the amount of fuel in whole Litres currently in the fuel tank
     * @param int Object: litre
     */
	public void setFuel(int fuel) {
		this.fuel = fuel;
	}	

    /***
     * judge the car is renting
     * @return boolean Object
     */
	public boolean isRent() {
		return isRent;
	}

    /***
     * set the car is renting
     * @param boolean Object
     */
	public void setRent(boolean isRent) {
		this.isRent = isRent;
	}

    /***
     * judge whether the car's fuel tank is full or not
     * @return boolean Object
     */
	public boolean fuelFull() {
		boolean fuelFull = false;
		
		if(this.fuel==this.tankCapacity){
			fuelFull=true;
		}
		
		return fuelFull;
	}

    /***
     * add a given number of whole Litres to the fuel tank
     * indicates how much fuel was added to the tank
     * @param int Object: a given number of whole Litres to the fuel tank
     * @return boolean Object: how much fuel was added to the tank
     */
	public int addFuel(int litre) {
		if (litre < 0) {
			litre = 0;
		}

		int curFuel = this.fuel;

		if ((curFuel + litre) > this.tankCapacity) {
			litre = this.tankCapacity - curFuel;
			curFuel = this.tankCapacity;
		} else {
			curFuel = litre + curFuel;
		}

		this.fuel = curFuel;
		
		return litre;
	}

    /***
     * Get a new or existing instance of a car based on carType,
     * @param String Object: the type of car need to be created
     * @return Car Object: a new instance of a car
     */ 
	public static Car getInstance(String type){
		if(type.equals("large")){
			return new LargeCar();
		}else if(type.equals("small")){
			return new SmallCar();
		}else{
			throw new IllegalArgumentException("There are not this type.");
		}
	}
	
    /***
     * Get a given number of instance of a car based on carType,
     * @param String Object: the type of cars need to be created
     * @param int Object: how many cars will be created
     * @return List<Car> Object: a list contain some new instance of cars
     */ 
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((registrationNum == null) ? 0 : registrationNum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractCar other = (AbstractCar) obj;
		if (registrationNum == null) {
			if (other.registrationNum != null)
				return false;
		} else if (!registrationNum.equals(other.registrationNum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractCar [registrationNum=" + registrationNum.toString() + ", isRent=" + isRent + ", tankCapacity="
				+ tankCapacity + ", fuel=" + fuel + ", carType=" + carType + "]";
	}

	
}
