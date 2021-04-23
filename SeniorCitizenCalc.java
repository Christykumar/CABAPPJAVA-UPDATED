package com.christyapp;
import java.time.LocalDate;
/**
 * Calculates the age of the rider if he is senior citizen he will get discount
 * @author chri2631
 *
 */
public class SeniorCitizenCalc {
	public static void seniorCitizen(String dateOfBirth, double totalAfterPeak) {
		LocalDate dateOfBirthNo = LocalDate.parse(dateOfBirth); //converts string date to integer date
		LocalDate currentDate= LocalDate.now();
		System.out.println("DOB : " + dateOfBirthNo);
		int dobYear= dateOfBirthNo.getYear(); //Gets the year mentioned in the date of birth
		int currentYear=currentDate.getYear();  //Gets the Current Year
		int age=currentYear-dobYear;//calculates the year
	    if(age>59) {
	    	double totalDiscount=totalAfterPeak/2; //50% discount for the senior citizens
	    	System.out.println("Total after the senoior citizen discount"+ totalDiscount);
	    }
	    else {
	    	System.out.println("No senior citizen discounts");
	    	System.out.println("same amount:"+ totalAfterPeak);
	    }
	}
}