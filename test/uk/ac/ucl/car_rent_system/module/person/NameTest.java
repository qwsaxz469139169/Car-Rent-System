package uk.ac.ucl.car_rent_system.module.person;

import org.junit.Test;

public class NameTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInstance() {
		Name.getInstance("Yuchen", "");
	}

}
