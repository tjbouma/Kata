package pillar;
import static org.junit.Assert.*;


import org.junit.Test;

public class BabysitterTest {

	@Test
	public void startNoEarlierThan5pmLeaveNoLaterThan4am() {
		Babysitter babysitter = new Babysitter();
		assertEquals("1", babysitter.calcTotalPay(17, 4));
	}
	
}
