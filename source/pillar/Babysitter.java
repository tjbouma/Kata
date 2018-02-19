package pillar;
public class Babysitter {
	public int calcTotalPay(int start, int end, int bedtime) {
	
		int startRate = 12;
		int bedtimeRate = 8;
		int midnight = 24;
		int startPay;
		int bedtimePay;
		
		//Babysitter can't start before 5pm (17 on 24hr clock)
		if (start < 17) {
			return 0;
		}
		
		/*Babysitter can't stay passed 4am (4 on 24hr clock)
		 * 
		 * (end < 17) to ensure program runs when babysitter leaves before 1am
		 */
		if (end > 4 && end < 17) {
			return 0;
		}
		
		//calculate start to bedtime pay
		startPay = (bedtime - start) * startRate;
		
		//calculate bedtimePay
		bedtimePay = (midnight - bedtime) * bedtimeRate;
		
		return (startPay + bedtimePay);
	}
}
