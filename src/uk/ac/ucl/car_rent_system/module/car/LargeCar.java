package uk.ac.ucl.car_rent_system.module.car;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public final class LargeCar extends AbstractCar {	
	
	public LargeCar(){
		Initialize();
	}
	
    /***
     * Initialize some properties a large car need
     */
	private void Initialize() {
		RegistrationNum registrationNum = createRegistrationNum();	
		this.setRegistrationNum(registrationNum);	
		this.setTankCapacity(60);
		this.setCarType("large");
		this.addFuel(60);
	}

	/***
     * create a new registration number of large car
     * @return  RegistrationNum Object: a new registration number of large car
     */
	public RegistrationNum createRegistrationNum() {
		String firstComponent = "LC"+SystemTool.getRandomNum();
		String secondComponent = SystemTool.getRandomLetter();
		
		RegistrationNum rn = RegistrationNum.getInstance(firstComponent, secondComponent);
		
		return rn;
	}

	/***
     * drive the large car for a given number of whole Kilometres that returns the number of whole Litres of fuel consumed during the journey
     * @param int Object: a given number of whole Kilometres
     * @return int Object:  the number of whole Litres of fuel consumed during the journey
     */
	public int driveCar(int kilometer) {
		boolean rent = this.isRent();
		int fuel2 = this.getFuel();

		if (kilometer <= 0 || !this.isRent() || this.getFuel() <= 0) {
			throw new IllegalArgumentException("The car cannot drive.");
		}

		int consumeFule = 0;
		int fuel = this.getFuel();

		if (kilometer <= 50) {	
			consumeFule = kilometer / 10;
			
			if (kilometer % 10 > 0) {
				consumeFule = consumeFule + 1;
			}	
			
		} else if (kilometer > 50) {
			consumeFule = 5 + (kilometer - 50) / 15;
			
			if ((kilometer - 50) % 15 > 0) {
				consumeFule = consumeFule + 1;
			}
		}

		fuel = fuel - consumeFule;
		this.setFuel(fuel);

		return consumeFule;
	}

}
