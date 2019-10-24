package uk.ac.ucl.car_rent_system.module.person;

import java.util.HashMap;
import java.util.Map;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public final class Name {
	private String firstName;
	
	private String lastName;
	
	private static final Map<String, Name> NAMES = new HashMap<>();

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
    /***
     * get a new name or existing instance of the name
     * @param String Object with firstName first name to be added
     * @param String Object withlastName last name to be added
     * @return Name Object with a new name or existing instance
     */
	public static Name getInstance(String firstName, String lastName){
		if(SystemTool.isEmpty(firstName)||SystemTool.isEmpty(lastName)){
			throw new IllegalArgumentException("Parameters are missing!");
		}
		
		final String k = firstName+lastName;
		
		if(!NAMES.containsKey(k)){
			NAMES.put(k, new Name(firstName,lastName));
		}
		return NAMES.get(k);
	}
	
    /***
     * get the first name of the person
     * @return String Object with the first name of the person
     */
	public String getFirstName() {
		return firstName;
	}
	
    /***
     * Set the first name of the person for the current object
     * @param String Object with first name to be added
     */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /***
     * get the last name of the person
     * @return String Object with the last name of the person
     */
	public String getLastName() {
		return lastName;
	}
	
    /***
     * Set the last name of the person for the current object
     * @param String Object with last name to be added
     */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
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
		Name other = (Name) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	
	
	
}
