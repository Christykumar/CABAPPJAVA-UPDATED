package com.christyapp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;
import gstCalc.GstCalculatin;
public class Inputs {
	/**
	 * This method gets the input details like mobile number and password for login credentials
	 */

	public static void inputGetLogin() {
		System.out.println("Welocome to BOOKYOURJOURNEY");                    //Displays the app name
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter mobile number:");
		long mobileNo;
		mobileNo = sc.nextLong();
		System.out.println("Enter the password(eight charecters must):");
		String passcode=sc.next();
		if(LoginVerrification.verifyMobileNoAndPasscode(mobileNo,passcode)) {/*If the login credentials meet the
	                                                                     expected level it does the next process*/
			inputCarType();                                                          
		}
		else {                                                                /*else it gets the same credentials until           
			                                                                  the level is met*/
			inputGetLogin();                                                  
		}                                                      
	}
	/**
	 * Gets the input of the car type preference from user and the kilometer they need to travel
	 * and gives the actual total and the total with GST as an output to the user
	 */
	public static void inputCarType() {
        System.out.println(" 1.MICRO(rs.10/km)\n 2.MINI(rs.15/km)\n 3.PRIME(rs.20/km)\n");
        /*Tells the user of the availability of cars and asks the user 
         for the preference*/
        Scanner ct = new Scanner(System.in);
        System.out.println("Select the number adjacent to the car type\n");
	    final int preference = ct.nextInt();
	    System.out.println("Enter the number of kilometers you need to travel: ");
	    double kilometer= ct.nextDouble();
		System.out.println("Enter number of kilometers");
		double price= PriceEstimator.priceEstimatorMethod(kilometer,preference);   //Actual price is calculated
		if(price!=0) {                   //If cab type is valid prints the total price
			                               //it proceeds with the next steps
		    System.out.println("Total Amount: "+ price);
		    double totalWithGst=GstCalculatin.calculateGst(price);      //Total amount with GST is calculated
		    inputBookingDate(kilometer,totalWithGst) ;    
		                                                             //Booking date function is called
		}
		else {                            //else it gets the car type again until it gets correct car type
			inputCarType();                              
		}
	}
	/**
	 * Gets the journey date as input
	 * @param kilometer
	 * @param ToatlWithGst
	 */
	public static void inputBookingDate(double kilometer,double totalWithGst) {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter the Journey date(format yyyy/mm/dd): ");
		String journeyDateStr = cs.next();                                              //format yyyy-mm-dd
		if(BookingTime.bookingDateDisplay(journeyDateStr)) {
			inputBookingTime(kilometer, totalWithGst ,journeyDateStr);  //Proceeds to next if date is valid
		}
		else {
			inputBookingDate(kilometer,totalWithGst);                  /*If the date is not valid asks for input
			                                                           until valid time is given*/      
		}
	}
	/**
	 * Gets the Journey time from the user
	 * @param kilometer
	 * @param ToatlWithGst
	 * @param JourneyDateStr
	 */
	public static void inputBookingTime(double kilometer, double totalWithGst,String journeyDateStr) {
		Scanner da = new Scanner(System.in);
		System.out.println("Enter the Journey Time(format hh:mm:ss): ");
		String journeyTimeStr = da.next();//format hh:mm:ss
		LocalTime journeyTimeNo = LocalTime.parse(journeyTimeStr);
		int hour = journeyTimeNo.getHour();
		if(BookingTime.bookingTimeDisplay(journeyTimeStr, journeyDateStr)==1) { //Validates the give time for the ride
		    double toatalAfterPeakHourCharge=PeakHourCharges.peakHourChargesMethod(hour,kilometer,totalWithGst);
		                                                          /*if time is valid takes
		                                                           *  input for the peak hour checking*/
		    dateOfBirth(toatalAfterPeakHourCharge);                         //proceeds to next
		}
		else {
			 inputBookingTime(kilometer, totalWithGst, journeyDateStr);/*If the date is not valid asks for input
                                                                       until valid time is given*/   
		}
	}
	/**
	 * Gets date of birth for senior citizen calculation 
	 * @param ToatalAfterPeak
	 */
	public static void dateOfBirth(double totalAfterPeak) {
		Scanner dob = new Scanner(System.in);
		System.out.println("Enter the Date of birth(format yyyy/mm/dd): ");
		String dateOfBirth = dob.next(); //format yyyy-mm-dd
		SeniorCitizenCalc.seniorCitizen(dateOfBirth , totalAfterPeak);      
	}
	public static void main(String[] args) {         //main function called
		inputGetLogin();
	}
	}
	


