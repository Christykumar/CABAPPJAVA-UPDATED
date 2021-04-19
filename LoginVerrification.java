

public class LoginVerrification {
     /**
      * gets the mobile number and pass code from user and verify its essential meet up levels
      * @param mobileNo
      * @param passcode
      * @return
      */
	public static boolean verifyMobileNoAndPasscode(long mobileNo,String passcode) {
	String mobileNoVerification = String.valueOf(mobileNo);
	int firstno=(int) (mobileNo/1000000000);
	String PassVerification = String.valueOf(passcode);
	if(mobileNoVerification.length()==10 || firstno==0 || firstno>5) {/* Checks wheather the mobile number is a 10 
	                                                             number and the passcode's length is of 8 */
		 if(PassVerification.length()==8 ){  
		System.out.println("Login Successfull");
	    }
		 return true;
	}
	else {
		System.out.println("Login unsuccessfull");
		return false;
	}
	}
}

