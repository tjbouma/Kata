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
	@Test
	public void whenStartingAt5pmBedtimeIs9pmLeaveAtMidnight() {
		Babysitter babysitter = new Babysitter();
		assertEquals(72, babysitter.calcTotalPay(17, 24, 21));
	}
	@Test
	public void whenStartingAt6pmAndLeavingAt9pmNoBedtime() {
		Babysitter babysitter = new Babysitter();
		assertEquals(36, babysitter.calcTotalPay(18, 21, 0));
	}
	
}
