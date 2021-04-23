package com.christyapp;

public class PeakHourCharges {
	/**
	 * checks for the peak hour timing and applies extra charges for the peak hours (1.25%)
	 * @param hour
	 * @param kilometer
	 * @param TotalWithGst
	 * @return
	 */
	public static double peakHourChargesMethod(int hour, double kilometer,double totalWithGst) {
		
		if (hour >= 17 && hour <= 19) {
			System.out.println("peakhours is between 18:00 and 19:00");
			double totalAfterPeakHourCharge= totalWithGst+((kilometer*1.25)/100);
			System.out.println("Toatal amount After the Peak hour estimation"+ totalAfterPeakHourCharge );
			return totalAfterPeakHourCharge;
		} 
		else {
			System.out.println("normal hours so no extra charges");
			double totalAfterPeak= totalWithGst+(kilometer*0);
			System.out.println("Toatal amount After the Peak hour estimation"+ totalAfterPeak );
			System.out.println("Normal hours so no extra charge");
			return totalAfterPeak;
			
		}
	}

}
