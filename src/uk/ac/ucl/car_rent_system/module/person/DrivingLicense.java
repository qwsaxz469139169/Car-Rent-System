package uk.ac.ucl.car_rent_system.module.person;

import java.util.Date;
import java.util.HashMap;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class DrivingLicense {
	
    private Person holder;
    
    private Date issueDate;
    
    private boolean isFullLicense;

    private static String drivingLicense;
    
    private static final HashMap<String, DrivingLicense> drivingLicenseMap = new HashMap<>();
     	   	
	public DrivingLicense(Person holder, Date issueDate, boolean isFullLicense) {
		this.issueDate = issueDate;
		this.holder = holder;
		this.isFullLicense = isFullLicense;
	}

    /***
     * Get the number of the driving license
     * @return String Object with the number of the driving license
     */
	public String getDrivingLicense() {
		return drivingLicense;
	}

    /***
     * Get the date of issue of the driving license
     * @return Date Object with the issue date of the driving license
     */
	public Date getIssueDate() {
		return issueDate;
	}

    /***
     * Get the holder of the driving license
     * @return Person Object with the holder of the driving license
     */
	public Person getHolder() {
		return holder;
	}

    /***
     * Get the full driving license number
     * @return String Object the driving license
     */
	public boolean isFullLicense() {
		return isFullLicense;
	}
	
    /***
     * Get the how many years the driving license issued
     * @return int Object years
     */
	public int getIssueDatetoNow(){	
		return SystemTool.getYeartoNow(issueDate);
	}

    /***
     * Get a new driving license based on a person,
     * @param Person Object: the person that the driving license belongs to
     * @param Date Object: issueDate date that the driving license was issued
     * @param boolean Object: isFullLicense true if the driving license is full, false if it is not
     * @return DrivingLicense Object: a new one of a driving license
     */
	private static DrivingLicense createDrivingLicence(Person holder,Date issueDate,boolean isFullLicense) {
		String firstComponent = "";
		String midComponent = "";
		String finalComponent = "";

		firstComponent = holder.getName().getFirstName().substring(0, 1)
				+ holder.getName().getLastName().substring(0, 1);

		midComponent = SystemTool.getYearString(issueDate);

		finalComponent = SystemTool.getRandomNum();
		
	    drivingLicense = firstComponent + "-" + midComponent + "-" + finalComponent;
        
		return new DrivingLicense(holder, issueDate, isFullLicense);
	}
	
    /***
     * Get a new or existing instance of a driving license based on a person,
     * @param Person Object: the person that the driving license belongs to
     * @param Date Object: issueDate date that the driving license was issued
     * @param boolean Object: isFullLicense true if the driving license is full, false if it is not
     * @return DrivingLicense Object: a new instance or a existing one of a driving license
     */
    public static DrivingLicense getInstance(Person holder, Date issueDate, boolean isFullLicense)
    {
        if(holder == null||issueDate==null||!isFullLicense){
            throw new IllegalArgumentException("Parameters are missing!");
        }

        String name = holder.getName().toString();
        Date age = holder.getBirth();
        String tempKey = name + SystemTool.getYearString(age);

        if(!drivingLicenseMap.containsKey(tempKey))
        {
            drivingLicenseMap.put(tempKey, createDrivingLicence(holder, issueDate, isFullLicense));
        }

        return  drivingLicenseMap.get(tempKey);
    }

    /***
     * Get the first component of the driving license number
     * @return String Object
     */
	public String getFirstComponent() {
		String[] split = drivingLicense.split("-");
		return split[0];
	}
	
    /***
     * Get the mid component of the driving license number
     * @return String Object
     */
	public String getMidComponent() {
		String[] split = drivingLicense.split("-");
		return split[1];
	}
	
    /***
     * Get the final component of the driving license number
     * @return String Object
     */
	public String getFinalComponent() {
		String[] split = drivingLicense.split("-");
		return split[2];
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((holder == null) ? 0 : holder.hashCode());
		result = prime * result + (isFullLicense ? 1231 : 1237);
		result = prime * result + ((issueDate == null) ? 0 : issueDate.hashCode());
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
		DrivingLicense other = (DrivingLicense) obj;
		if (holder == null) {
			if (other.holder != null)
				return false;
		} else if (!holder.equals(other.holder))
			return false;
		if (isFullLicense != other.isFullLicense)
			return false;
		if (issueDate == null) {
			if (other.issueDate != null)
				return false;
		} else if (!issueDate.equals(other.issueDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return drivingLicense;
	}
	
	
	
	
}
