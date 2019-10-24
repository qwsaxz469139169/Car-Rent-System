package uk.ac.ucl.car_rent_system.module.car;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class SmallCar extends AbstractCar {
	
	public SmallCar() {
		Initialize();	
	}
	
    /***
     * Initialize some properties a small car need
     */
	private void Initialize() {
		RegistrationNum registrationNum = createRegistrationNum();	
		this.setRegistrationNum(registrationNum);	
		this.setTankCapacity(49);
		this.setCarType("small");
		this.addFuel(49);
	}

	/***
     * create a new registration number of small car
     * @return  RegistrationNum Object: a new registration number of small car
     */
	public RegistrationNum createRegistrationNum() {
		String firstComponent = "SC"+SystemTool.getRandomNum();
		String secondComponent = SystemTool.getRandomLetter();
		
		RegistrationNum rn = RegistrationNum.getInstance(firstComponent, secondComponent);
		
		return rn;
	}

	/***
     * drive the small car for a given number of whole Kilometres that returns the number of whole Litres of fuel consumed during the journey
     * @param int Object: a given number of whole Kilometres
     * @return int Object:  the number of whole Litres of fuel consumed during the journey
     */
	public int driveCar(int kilometer) {
		
		if (kilometer <= 0 || !this.isRent() || this.getFuel() <= 0) {
			throw new IllegalArgumentException("The car cannot drive.");
		}

		int consumeFule = 0;
		int fuel = this.getFuel();

		consumeFule = kilometer / 20;

		if (kilometer % 20 > 0) {
			consumeFule = consumeFule + 1;
		}

		fuel = fuel - consumeFule;
		this.setFuel(fuel);

		return consumeFule;
	}
		
}
