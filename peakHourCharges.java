
public class peakHourCharges {
	/**
	 * checks for the peak hour timing and applies extra charges for the peak hours (1.25%)
	 * @param hour
	 * @param kilometer
	 * @param TotalWithGst
	 * @return
	 */
	public static double peakHourChargesMethod(int hour, double kilometer,double TotalWithGst) {
		
		if (hour >= 17 && hour <= 19) {
			System.out.println("peakhours is between 18:00 and 19:00");
			double ToatalAfterPeak= TotalWithGst+((kilometer*1.25)/100);
			System.out.println("Toatal amount After the Peak hour estimation"+ ToatalAfterPeak );
			return ToatalAfterPeak;
		} 
		else {
			System.out.println("normal hours so no extra charges");
			double ToatalAfterPeak= TotalWithGst+(kilometer*0);
			System.out.println("Toatal amount After the Peak hour estimation"+ ToatalAfterPeak );
			System.out.println("Normal hours so no extra charge");
			return ToatalAfterPeak;
			
		}
	}

}
