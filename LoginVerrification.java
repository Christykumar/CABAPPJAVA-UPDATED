

public class LoginVerrification {
     /**
      * gets the mobile numberand passcode from user and verifys its essential meetup levels
      * @param mobileNo
      * @param passcode
      * @return
      */
	public static boolean verifyMobileNoAndPasscode(long mobileNo,String passcode) {
	String mobileNoVerification = String.valueOf(mobileNo);
	String PassVerification = String.valueOf(passcode);
	if(mobileNoVerification.length()==10 && PassVerification.length()==8) {/* Checks wheather the mobile number is a 10 
	                                                      number and the passcode's length is of 8 */
		System.out.println("Login Successfull");
		return true;
	}
	else {
		System.out.println("Login unsuccessfull");
		return false;
	}
	}
}
