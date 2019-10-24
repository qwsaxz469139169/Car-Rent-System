package uk.ac.ucl.car_rent_system.module.person;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DrivingLicenseTest {
	
    DrivingLicense drivingLicense;
    Date issueDate;
    Person person;
	
	@Before
    public void setUp() throws Exception {
        Calendar tempDate = Calendar.getInstance();
        tempDate.set(1996, 5, 9);
        
        Name name = new Name("Yuchen","Guo");

        person = new Person(name, tempDate.getTime());

        tempDate.set(2016, 5, 10);
        issueDate = tempDate.getTime();
        
        drivingLicense = DrivingLicense.getInstance(person, issueDate, true);
    }

	@Test
	public void testGetIssueDatetoNow() {
	   assertEquals(3, drivingLicense.getIssueDatetoNow());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetInstance() {
		DrivingLicense.getInstance(person, issueDate, false);
	}
	    
}
