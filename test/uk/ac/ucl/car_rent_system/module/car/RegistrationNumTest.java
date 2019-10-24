package uk.ac.ucl.car_rent_system.module.car;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegistrationNumTest {

	@Test(expected = IllegalArgumentException.class)
	public void testGetInstance() {
		RegistrationNum.getInstance("111", "11");
	}

}
