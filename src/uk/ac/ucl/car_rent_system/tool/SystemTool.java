package uk.ac.ucl.car_rent_system.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SystemTool {

    /***
     * get a two digit number
     * @return int Object
     */
	public static String getRandomNum(){
		int random = new Random().nextInt(98)+1;
		
		String result = String.format("%02d", random);
		
		return result;	
	}
	
    /***
     * get three random uppercase letters
     * @return String Object
     */
	public static String getRandomLetter() {
		String result = "";
		
		for (int i = 0; i < 3; i++) {
			result += String.valueOf((char) (new Random().nextInt(26) + 65));
		}
		
		return result;
	}
	
    /***
     * Convert Date to a String in yyyy format
     * @param Date Object
     * @return String Object
     */
	public static String getYearString(Date date) {
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		result= sdf.format(date);
		
		return result;
	}	
	
    /***
     * Calculates the number of years from the specified year to the present
     * @param Date Object
     * @return int Object 
     */
	public static int getYeartoNow(Date past){
		Calendar calendar= Calendar.getInstance();
		
		int now = calendar.get(Calendar.YEAR);
		
		calendar.setTime(past);
		
		return now - calendar.get(Calendar.YEAR);
		
	}
	
    /***
     * get the current time
     * @return Date Object 
     */
	public static Date getNowYear(){
		Calendar calendar= Calendar.getInstance();
		return calendar.getTime();
	}
	
	
    /***
     * judge if the String is empty
     * @param String Object
     * @return boolean Object 
     */
	public static boolean isEmpty(String str){
		if(str.equals("")||str==null||str==""){
			return true;
		}else {
			return false;
		}
	}
}
