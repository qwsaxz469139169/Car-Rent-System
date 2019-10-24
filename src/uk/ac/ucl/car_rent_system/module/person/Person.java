package uk.ac.ucl.car_rent_system.module.person;

import java.util.Date;

import uk.ac.ucl.car_rent_system.module.car.Car;
import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class Person{
	
	private Name name;
	
	private Date birth;
	
	private Car car;
	
	private DrivingLicense drivingLicense;
	
	public Person(Name name, Date birth) {
		this.name = name;
		this.birth = birth;
	}

    /***
     * Function to get the full name of a Person
     * @return Returns Name Object
     */
	public Name getName() {
		return name;
	}

    /***
     * get the date of birth of the person
     * @return Date Object with the date of birth of the person
     */
	public Date getBirth() {
		return birth;
	}

    /***
     * Set the birth date of the person for the current object
     * @param Date Object with the date of birth of the person
     */
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
    /***
     * get the car of the person rent
     * @return Car Object with the car that person rent
     */
	public Car getCar() {
		return car;
	}

    /***
     * set the car of the person rent
     * @param Car Object with the car that the person rent
     */
	public void setCar(Car car) {
		this.car = car;
	}

    /***
     * get the drivingl license of the person
     * @return DrivingLicence Object 
     */
	public DrivingLicense getDrivingLicense() {
		return drivingLicense;
	}

    /***
     * set the driving licence of the person
     * @param DrivingLicence Object
     */
	public void setDrivingLicense(DrivingLicense drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	
    /***
     * get the age of the person
     * @return int Object
     */
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
		return "Person [name=" + name.toString() + ", birth=" + birth + ", car=" + car.toString() + ", drivingLicense="
				+ drivingLicense.toString() + "]";
	}
	
	


}
