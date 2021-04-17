
public class PriceEstimator {
	/**
	 * CAlculates the total amount by getting the car type and kilometer as input
	 * @param kilometer
	 * @param preference
	 * @return the amount as the out put
	 */
	public static double PriceEstimatorMethod(double kilometer, int preference) {
		double price;
		System.out.println("CARTYPE:");
		if (preference == 1) {
			System.out.println("MICRO SELECTED\n");
			return price= 10*kilometer;            //rs.10 per kilometer for micro cars
		} else if (preference == 2) {
			System.out.println("MINI SELECTED\n");
			return price= 15*kilometer;            //rs.15 per kilometer for mini cars
		} else if (preference == 3) {
			System.out.println("PRIME SELECTED\n");
			return price= 20*kilometer;            //rs.20 per kilometer for prime cars
		} else {
			System.out.println("Select the valid number\n");
			inputs.inputCarType();
			return 0;
			
	}
	}

}
