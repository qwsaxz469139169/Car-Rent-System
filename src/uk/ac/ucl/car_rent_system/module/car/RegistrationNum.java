package uk.ac.ucl.car_rent_system.module.car;

import java.util.HashMap;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class RegistrationNum {

	private String firstComponent;

	private String secondComponent;

	private static final String componentOnePattern = "^[A-Z]{2}[0-9]{2}$";
	private static final String componentTwoPattern = "^[A-Z]{3}$";

	private static final HashMap<String, RegistrationNum> registrationsMap = new HashMap<>();

	public RegistrationNum(String firstComponent, String secondComponent) {
		this.firstComponent = firstComponent;
		this.secondComponent = secondComponent;
	}

    /***
     * Get a new or existing instance of a registration number based on type of a car,
     * @param String Object: the first component of the registration number
     * @param String Object: the second component of the registration number
     * @return RegistrationNum Object: a new instance or a existing one of a registration number
     */
	public static RegistrationNum getInstance(String firstComponent, String secondComponent) {
		if (SystemTool.isEmpty(firstComponent) || SystemTool.isEmpty(secondComponent)
				|| !firstComponent.matches(componentOnePattern) || !secondComponent.matches(componentTwoPattern)) {

			throw new IllegalArgumentException("The components do not match the pattern");
		}

		if (!registrationsMap.containsKey(firstComponent + secondComponent)) {
			registrationsMap.put(firstComponent + secondComponent,
					new RegistrationNum(firstComponent, secondComponent));
		}

		return registrationsMap.get(firstComponent + secondComponent);

	}

    /***
     * get the first component of the registration number
     * @return String Object
     */
	public String getFirstComponent() {
		return firstComponent;
	}

    /***
     * get the second component of the registration number
     * @return String Object
     */
	public String getSecondComponent() {
		return secondComponent;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstComponent == null) ? 0 : firstComponent.hashCode());
		result = prime * result + ((secondComponent == null) ? 0 : secondComponent.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (!(obj instanceof RegistrationNum))
			return false;

		RegistrationNum rNumber = (RegistrationNum) obj;

		return (firstComponent == null ? rNumber.firstComponent == null : firstComponent.equals(rNumber.firstComponent))
				&& (secondComponent == null ? rNumber.secondComponent == null
						: secondComponent.equals(rNumber.secondComponent));
	}

	@Override
	public String toString() {
		return firstComponent + " " + secondComponent;
	}

}
