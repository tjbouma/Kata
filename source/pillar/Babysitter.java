package pillar;

public class Babysitter {
	public int calcTotalPay(int start, int end, int bedtime) {

		int startRate = 12;
		int bedtimeRate = 8;
		int endRate = 16;
		int midnight = 24;
		int startPay;
		int bedtimePay;
		int endtimePay;
		int totalPay;

		// Babysitter can't start before 5pm (17 on 24hr clock)
		if (start < 17) {
			return 0;
		}

		/*
		 * Babysitter can't stay passed 4am (4 on 24hr clock)
		 * 
		 * (end < 17) to ensure program runs when babysitter leaves before 1am
		 */
		if (end > 4 && end < 17) {
			return 0;
		}

		// calculate startPay when there is no bedtime
		if (bedtime == 0 && end > 17) {
			bedtimePay = 0;
			startPay = (end - start) * startRate;

		}

		// calculate startPay when there is no bedtime and leave after midnight
		else if (bedtime == 0 && end < 17) {
			bedtimePay = 0;
			startPay = (midnight - start) * startRate;
		}

		else {
			// calculate start to bedtime pay
			startPay = (bedtime - start) * startRate;

			// calculate bedtime pay
			bedtimePay = (midnight - bedtime) * bedtimeRate;
		}
		
		// calculate midnight to end pay if after midnight
		if (end <= 4) {
			endtimePay = (end + 24 - midnight) * endRate;

		} else {
			endtimePay = 0;
		}
		
		// calculate total night pay
		totalPay = endtimePay + bedtimePay + startPay;

		return totalPay;
	}
}
