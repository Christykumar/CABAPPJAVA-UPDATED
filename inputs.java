import java.time.LocalDate;
import java.util.Scanner;
import gstCalc.GstCalculatin;
public class inputs {
	/**
	 * This method gets the input details like mobile number and password for login credentials
	 */

	public static void inputgetLogin() {
		System.out.println("Welocome to BOOKYOURJOURNEY");                    //Displays the app name
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter mobile number:");
		long mobileNo;
		mobileNo = sc.nextLong();
		System.out.println("Enter the password(eight charecters must):");
		String passcode=sc.next();
		if(LoginVerrification.verifyMobileNoAndPasscode(mobileNo,passcode)==true) {/*If the login credentials meet the
	                                                                     expected level it does the next process*/
			inputCarType();                                                          
		}
		else {                                                                /*else it gets the same credentials until           
			                                                                  the level is met*/
			inputgetLogin();                                                  
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
		double Price= PriceEstimator.PriceEstimatorMethod(kilometer,preference);   //Actual price is calculated
		if(Price==0) {                   //If cab type is valid it procceeds with the next steps
		    System.out.println("Total Amount: "+ Price);
		    double ToatlWithGst=GstCalculatin.CalculateGst(Price);      //Total amount with GST is calculated
		    inputBookingDate(kilometer,ToatlWithGst) ;    
		                                                             //Booking date function is called
		}
		else {                            //else it gets the cartype again until it gets correct car type
			inputCarType();                              
		}
	}
	/**
	 * Gets the journey date as input
	 * @param kilometer
	 * @param ToatlWithGst
	 */
	public static void inputBookingDate(double kilometer,double ToatlWithGst) {
		Scanner cs = new Scanner(System.in);
		System.out.println("Enter the Journey date(format yyyy/mm/dd): ");
		String JourneyDateStr = cs.next();                                              //format yyyy-mm-dd
		if(BookingTime.bookingDateDisplay(JourneyDateStr)==true) {
			inputBookingTime(kilometer, ToatlWithGst ,JourneyDateStr);  //Proceeds to next if date is valid
		}
		else {
			inputBookingDate(kilometer,ToatlWithGst);                  /*If the date is not valid asks for input
			                                                           until valid time is given*/      
		}
	}
	/**
	 * Gets the Journey time from the user
	 * @param kilometer
	 * @param ToatlWithGst
	 * @param JourneyDateStr
	 */
	public static void inputBookingTime(double kilometer, double ToatlWithGst,String JourneyDateStr) {
		Scanner da = new Scanner(System.in);
		System.out.println("Enter the Journey Time(format hh:mm:ss): ");
		String JourneyTimeStr = da.next();//format hh:mm:ss
		int hour=BookingTime.bookingTimeDisplay(JourneyTimeStr, JourneyDateStr); //Validates the give time for the ride
		if(hour!=0) {
		    
		    double TotalAfterPeak=peakHourCharges.peakHourChargesMethod(hour,kilometer,ToatlWithGst);
		                                                          /*if time is valid takes
		                                                           *  input for the peak hour checking*/
		    DateOfBirth(TotalAfterPeak);                         //proceeds to next
		}
		else {
			 inputBookingTime(kilometer, ToatlWithGst, JourneyDateStr);/*If the date is not valid asks for input
                                                                       until valid time is given*/   
		}
	}
	/**
	 * Gets date of birth for senior citizen calculation 
	 * @param ToatalAfterPeak
	 */
	public static void DateOfBirth(double ToatalAfterPeak) {
		Scanner dob = new Scanner(System.in);
		System.out.println("Enter the Date of birth(format yyyy/mm/dd): ");
		String DateOfBirth = dob.next(); //format yyyy-mm-dd
		SeniorCitizenCalc.SeniorCitizen(DateOfBirth , ToatalAfterPeak);      
	}
	public static void main(String[] args) {         //main function called
		inputgetLogin();
	}
	}
	


