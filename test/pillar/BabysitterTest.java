package pillar;
import static org.junit.Assert.*;


import org.junit.Test;

public class BabysitterTest {

	@Test
	public void startNoEarlierThan5pmLeaveNoLaterThan4am() {
		Babysitter babysitter = new Babysitter();
		assertEquals(0, babysitter.calcTotalPay(12, 4, 0));
	}
	@Test 
	public void whenStartingAt5pmAndBedtimeIs10pmAndLeaveAt4amCalculateTotalPay() {
		Babysitter babysitter = new Babysitter();
		assertEquals(140, babysitter.calcTotalPay(17, 4, 22));
	}
	
}
