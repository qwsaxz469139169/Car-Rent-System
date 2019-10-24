package uk.ac.ucl.car_rent_system.module.car;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class LargeCar extends AbstractCar {	
	
	public LargeCar(){
		Initialize();
	}
	
	private void Initialize() {
		RegistrationNum registrationNum = createRegistrationNum();	
		this.setRegistrationNum(registrationNum);	
		this.setTankCapacity(60);
		this.setCarType("large");
	}

	@Override
	public RegistrationNum createRegistrationNum() {
		String firstComponent = "LC"+SystemTool.getRandomNum();
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

		if (kilometer <= 50) {	
			consumeFule = kilometer / 10;
			
			if (kilometer % 10 > 0) {
				consumeFule = consumeFule + 1;
			}	
			
		} else if (kilometer > 50) {
			consumeFule = 500 + (kilometer - 50) / 15;
			
			if ((kilometer - 50) % 15 > 0) {
				consumeFule = consumeFule + 1;
			}
		}

		fuel = fuel - consumeFule;
		this.setFuel(fuel);

		return consumeFule;
	}

}
