package uk.ac.ucl.car_rent_system.module.person;

import java.util.Date;

import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class Person{
	
	private Name name;
	
	private Date birth;
	
	private Car car;
	
	private boolean canRent;
	
	private DrivingLicence drivingLicence;
	
	public Person(Name name, Date birth) {
		this.name = name;
		this.birth = birth;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public boolean isCanRent() {
		return canRent;
	}

	public void setCanRent(boolean canRent) {
		this.canRent = canRent;
	}

	public DrivingLicence getDrivingLicence() {
		return drivingLicence;
	}

	public void setDrivingLicence(DrivingLicence drivingLicence) {
		this.drivingLicence = drivingLicence;
	}
	
	public int getAge(){
		return SystemTool.getYeartoNow(birth);		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Person other = (Person) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name.toString() + ", birth=" + birth + ", car=" + car.toString() + ", canRent=" + canRent + ", drivingLicence="
				+ drivingLicence.toString() + "]";
	}
	
	


}
