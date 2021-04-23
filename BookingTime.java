package com.christyapp;
import java.time.LocalDate;
import java.time.LocalTime;

public class BookingTime {
	/**
	 * Booking date is verified as that it is After the current date
	 * 
	 * @param JourneyDateStr
	 * @return
	 */
	public static boolean bookingDateDisplay(String journeyDateStr) {
		LocalDate journeyDateNo = LocalDate.parse(journeyDateStr);
		LocalDate currentDay = LocalDate.now();
		if (journeyDateNo.isAfter(currentDay) || journeyDateNo.equals(currentDay)) {
			System.out.println("JourneyDate:" + journeyDateNo);
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
	public static int bookingTimeDisplay(String journeyTimeStr, String journeyDateStr) {
		LocalTime journeyTimeNo = LocalTime.parse(journeyTimeStr);
		LocalTime currentTime = LocalTime.now();
		LocalDate currentDate =LocalDate.now();
		LocalDate journeyDateNo = LocalDate.parse(journeyDateStr);
		if (journeyDateNo == currentDate) {
		/*if the date is todays date it checks weather it is the current time or after the current time
		 * and extracts hour from the time*/
			if (journeyTimeNo.isAfter(currentTime) || (journeyTimeNo.equals(currentTime))) {
				System.out.println("JourneyTime:" + journeyTimeNo);
			}
			return 1;
		} else if (journeyDateNo.isAfter(currentDate)) {
		//if it after today do not checks the correct date just extracts hour from the time
			System.out.println("JourneyTime:" + journeyTimeNo);
			return 1;
			//returns hour because the time is not before today
			//hour ACTS as true or false statement
		} else {
			return 0;
		}
	}
}
