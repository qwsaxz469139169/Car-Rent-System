package uk.ac.ucl.car_rent_system.module.person;

import java.util.Date;

import uk.ac.ucl.car_rent_system.module.car.Car;

public class Person{
	
	private Name name;
	
	private Date age;
	
	private Car car;
	
	private boolean canRent;
	
	private DrivingLicence drivingLicence;
	
	public Person(Name name, Date age) {
		this.name = name;
		this.age = age;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
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
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
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
		return "Person [name=" + name.toString() + ", age=" + age + ", car=" + car.toString() + ", canRent=" + canRent + ", drivingLicence="
				+ drivingLicence.toString() + "]";
	}
	
	


}
