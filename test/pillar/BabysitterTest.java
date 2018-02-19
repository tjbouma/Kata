package pillar;
import static org.junit.Assert.*;
/*
 * @author Trevor Bouma
 */

import org.junit.Before;
import org.junit.Test;

public class BabysitterTest {
	
	Babysitter babysitter;
	
	@Before
	public void setUp() {
		babysitter = new Babysitter();
	}

	@Test 
	public void whenStartingAt5pmAndBedtimeIs10pmAndLeaveAt4amCalculateTotalPay() {
		assertEquals(140, babysitter.calcTotalPay(17, 4, 22));
	}
	@Test
	public void whenStartingAt5pmBedtimeIs9pmLeaveAtMidnight() {
		assertEquals(72, babysitter.calcTotalPay(17, 24, 21));
	}
	@Test
	public void whenStartingAt6pmAndLeavingAt9pmNoBedtime() {
		assertEquals(36, babysitter.calcTotalPay(18, 21, 0));
	}
	@Test
	public void whenStartingAt5pmAndLeaveAt4amNoBedtime() {
		assertEquals(148, babysitter.calcTotalPay(17, 4, 0));
	}
	@Test
	public void tryAndCatchExceptionStartingBefore5pm() throws Exception {
		try {
			babysitter.calcTotalPay(12, 4, 22);
		}
		catch(Exception e) {
			System.out.println("Babysitter can't start before 5pm");
		}
	}
	@Test
	public void tryandCatchExceptionStayingAfter4am() throws Exception {
		try {
			babysitter.calcTotalPay(17, 7, 22);
		}
		catch(Exception e) {
			System.out.println("Babysitter can't stay after 4am");
		}
	}


	
}
