package pillar;
public class Babysitter {
	public String calcTotalPay(int start, int end) {
		if (start < 17) {
			return "0";
		}
		if (end > 4 && end < 17) {
			return "0";
		}
		return "1";
	}
}
