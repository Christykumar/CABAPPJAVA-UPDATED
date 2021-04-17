import java.time.LocalDate;
/**
 * Calculates the age of the rider if he is senior citizen he will get discount
 * @author chri2631
 *
 */
public class SeniorCitizenCalc {
	public static void SeniorCitizen(String DateOfBirth, double ToatalAfterPeak) {
		LocalDate DateOfBirthNo = LocalDate.parse(DateOfBirth); //converts string date to interger date
		LocalDate CurrentDate= LocalDate.now();
		System.out.println("DOB : " + DateOfBirthNo);
		int dobyear= DateOfBirthNo.getYear(); //Gets the year mentioned in the date of birth
		int CurrentYear=CurrentDate.getYear();  //Gets the Current Year
		int age=CurrentYear-dobyear;//calculates the year
	    if(age>59) {
	    	double TotalDiscount=ToatalAfterPeak/2; //50% discount for the senior citizens
	    	System.out.println("Total after the senoior citizen discount"+ TotalDiscount);
	    }
	    else {
	    	System.out.println("No senior citizen discounts");
	    	System.out.println("same amount:"+ ToatalAfterPeak);
	    }
	}
}