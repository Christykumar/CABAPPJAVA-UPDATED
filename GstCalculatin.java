package gstCalc;

public class GstCalculatin {
	/**
	 * 7% GST is calculated for the total amount and returns the Total amount with gst as a output
	 * @param price
	 * @return
	 */
	public static double CalculateGst(double price) {
		double GST = (price * 7) / 100;
		double Total = GST + price;
		System.out.println("Your total bill amount with GST is: " + Total);
		return Total;
	}

}
