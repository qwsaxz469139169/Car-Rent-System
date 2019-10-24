package uk.ac.ucl.car_rent_system.module.car;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class SmallCar extends AbstractCar {
	
	public SmallCar() {
		Initialize();	
	}
	
	private void Initialize() {
		// TODO Auto-generated method stub
		RegistrationNum registrationNum = createRegistrationNum();	
		this.setRegistrationNum(registrationNum);	
		this.setTankCapacity(49);
		this.setCarType("small");
	}

	public RegistrationNum createRegistrationNum() {
		String firstComponent = "SC"+SystemTool.getRandomNum();
		String secondComponent = SystemTool.getRandomLetter();
		
		RegistrationNum rn = RegistrationNum.getInstance(firstComponent, secondComponent);
		
		return rn;
	}

	@Override
	public int driveCar(int kilometer) {
		
		if (kilometer <= 0 && !this.isRent() && this.getFuel() <= 0) {
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

		return fuel;
	}
		
}
