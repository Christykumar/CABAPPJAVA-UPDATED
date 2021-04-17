import java.time.LocalDate;
import java.time.LocalTime;

public class BookingTime {
	/**
	 * Booking date is verified as that it is After the current date
	 * 
	 * @param JourneyDateStr
	 * @return
	 */
	public static boolean bookingDateDisplay(String JourneyDateStr) {
		LocalDate JourneyDateNo = LocalDate.parse(JourneyDateStr);
		LocalDate CurrentDay = LocalDate.now();
		if (JourneyDateNo.isAfter(CurrentDay) || JourneyDateNo.equals(CurrentDay)) {
			System.out.println("JourneyDate:" + JourneyDateNo);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Check if the time is current time or before time if only the day is today
	 * 
	 * @param JourneyTimeStr
	 * @return
	 */
	public static int bookingTimeDisplay(String JourneyTimeStr, String JourneyDateStr) {
		LocalTime JourneyTimeNo = LocalTime.parse(JourneyTimeStr);
		LocalTime CurrentTime = LocalTime.now();
		LocalDate CurrentDate =LocalDate.now();
		LocalDate JourneyDateNo = LocalDate.parse(JourneyDateStr);
		int hour = 0;
		if (JourneyDateNo == CurrentDate) {
		/*if the date is todays date it checks weather it is the current time or after the current time
		 * and extracts hour from the time*/
			if (JourneyTimeNo.isAfter(CurrentTime) || (JourneyTimeNo.equals(CurrentTime))) {
				System.out.println("JourneyTime:" + JourneyTimeNo);
				hour = JourneyTimeNo.getHour();
			}
			return hour;
		} else if (JourneyDateNo.isAfter(CurrentDate)) {
		//if it after today do not checks the correct date just extracts hour from the time
			System.out.println("JourneyTime:" + JourneyTimeNo);
			hour = JourneyTimeNo.getHour();
			return hour;
			//returns hour because the time is not before today
			//hour ACTS as true or false statement
		} else {
			return 0;
			//return 0 if the time is before
		}
	}
}
