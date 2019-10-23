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
	}

	@Override
	public RegistrationNum createRegistrationNum() {
		String firstComponent = "LC"+SystemTool.getRandomNum();
		String secondComponent = SystemTool.getRandomLetter();
		
		RegistrationNum rn = RegistrationNum.getInstance(firstComponent, secondComponent);
		
		return rn;
	}

	@Override
	public int consumeFuel(int km) {

		if (km <= 0) {
			return 0;
		}

		int consumeFule = 0;
		int fuel = this.getFuel();

		if (km <= 50) {	
			consumeFule = km / 10;
			
			if (km % 10 > 0) {
				consumeFule = consumeFule + 1;
			}	
			
		} else if (km > 50) {
			consumeFule = 500 + (km - 50) / 15;
			
			if ((km - 50) % 15 > 0) {
				consumeFule = consumeFule + 1;
			}
		}

		fuel = fuel - consumeFule;
		this.setFuel(fuel);

		return consumeFule;
	}

}
