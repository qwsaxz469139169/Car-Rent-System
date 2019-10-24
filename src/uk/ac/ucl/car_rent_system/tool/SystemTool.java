package uk.ac.ucl.car_rent_system.tool;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class SystemTool {

	public static String getRandomNum(){
		int random = new Random().nextInt(98)+1;
		
		String result = String.format("%02d", random);
		
		return result;	
	}
	
	public static String getRandomLetter() {
		String result = "";
		
		for (int i = 0; i < 3; i++) {
			result += String.valueOf((char) (new Random().nextInt(26) + 65));
		}
		
		return result;
	}
	
	public static String getYearString(Date date) {
		String result = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		result= sdf.format(date);
		
		return result;
	}	
	
	public static int getYeartoNow(Date past){
		Calendar calendar= Calendar.getInstance();
		
		int now = calendar.get(Calendar.YEAR);
		
		calendar.setTime(past);
		
		return now - calendar.get(Calendar.YEAR);
		
	}
	
	public static Date getNowYear(){
		Calendar calendar= Calendar.getInstance();
		return calendar.getTime();
	}
	
	public static boolean isEmpty(String str){
		if(str.equals("")||str==null||str==""){
			return true;
		}else {
			return false;
		}
	}
}
