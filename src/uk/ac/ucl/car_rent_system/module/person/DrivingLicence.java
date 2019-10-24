package uk.ac.ucl.car_rent_system.module.person;

import java.util.Date;
import java.util.HashMap;

import uk.ac.ucl.car_rent_system.tool.SystemTool;

public class DrivingLicence {
	
    private Person holder;
    
    private Date issueDate;
    
    private boolean isFullLicense;

    private static String drivingLicense;
    
    private static final HashMap<String, DrivingLicence> drivingLicenseMap = new HashMap<>();
     	   	
	public DrivingLicence(Person holder, Date issueDate, boolean isFullLicense) {
		this.issueDate = issueDate;
		this.holder = holder;
		this.isFullLicense = isFullLicense;
	}

	public String getDrivingLicense() {
		return drivingLicense;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Person getHolder() {
		return holder;
	}

	public boolean isFullLicense() {
		return isFullLicense;
	}

	public void setFullLicense(boolean isFullLicense) {
		this.isFullLicense = isFullLicense;
	}
	
	public int getIssueDatetoNow(){	
		return SystemTool.getYeartoNow(issueDate);
	}

	private static DrivingLicence createDrivingLicence(Person holder,Date issueDate,boolean isFullLicense) {
		String firstComponent = "";
		String midComponent = "";
		String finalComponent = "";

		firstComponent = holder.getName().getFirstName().substring(0, 1)
				+ holder.getName().getLastName().substring(0, 1);

		midComponent = SystemTool.getYearString(issueDate);

		finalComponent = SystemTool.getRandomNum();
		
	    drivingLicense = firstComponent + "-" + midComponent + "-" + finalComponent;

		return new DrivingLicence(holder, issueDate, isFullLicense);
	}
	
    public static DrivingLicence getInstance(Person holder, Date issueDate, boolean isFullLicense)
    {
        if(holder == null ){
            throw new IllegalArgumentException("There are arguments missing");
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

	public String getFirstComponent() {
		String[] split = drivingLicense.split("-");
		return split[0];
	}
	
	public String getMidComponent() {
		String[] split = drivingLicense.split("-");
		return split[1];
	}
	
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
		DrivingLicence other = (DrivingLicence) obj;
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
