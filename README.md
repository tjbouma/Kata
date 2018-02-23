# Babysitter
This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward:

The babysitter:

starts no earlier than 5:00PM<br>
leaves no later than 4:00AM<br>
gets paid $12/hour from start-time to bedtime<br>
gets paid $8/hour from bedtime to midnight<br>
gets paid $16/hour from midnight to end of job<br>
gets paid for full hours (no fractional hours)<br>
Feature: As a babysitter In order to get paid for 1 night of work I want to calculate my nightly charge<br>

# Usage main method
The main method asks the user to input the time they start babysitting, the time the child went to bed, and the time they left.

public class MainBabysitter {
	
	public static void main(String [] args) throws Exception {
		Babysitter babysitter = new Babysitter();
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Time should be rounded down to the closest hour. For example 5:35pm should be 17.\nEnter start time using 24 hr clock: ");
		int start = reader.nextInt();
		
		System.out.println("Time should be rounded up to the closest hour. For example 10:27pm should be 23.\nIf the child does not go to bed, Enter 0. \nEnter bedtime using 24 hr clock: ");
		int bedtime = reader.nextInt();
		
		System.out.println("Time should be rounded up to the closest hour. For example 3:37am should be 4.\nEnter endtime using 24 hr clock: ");
		int endtime = reader.nextInt();
		
		int totalPay = babysitter.calcTotalPay(start,endtime,bedtime);
		System.out.printf("Total Night Pay: $%d%n", totalPay);
		
		reader.close();
	}
}

# Outputs 
Time should be rounded to the closest hour. For example 5:35pm should be 17.<br>
Enter start time using 24 hr clock: <USER INPUTS START AS 17><ENTER><br>

Time should be rounded up to the closest hour. For example 10:27pm should be 23.<br>
If the child does not go to bed, Enter 0.<br>
Enter endtime using 24 hr clock: <USER INPUTS BEDTIME AS 23><ENTER><br>
  
Time should be rounded up to the closest hour. For example 3:37am should be 4.<br>
Enter endtime using 24 hr clock: <USER INPUTS BEDTIME AS 4><ENTER><br>

Total Night Pay: $<calcTotalPay(start, end, bedtime)>

# Usage calcTotalPay()
The method uses the parameters start, endtime, bedtime in a 24 hour clock to calculate startPay(pay from start to bedtime),
bedtimePay(pay from bedtime to midnight), and endtimePay(pay from midnight to end).

when start = 17, end = 4, and bedtime = 23

calcTotalPay(17, 4, 23);

int startPay = (23 - 17) * 12;

int bedtimePay = (24 - 23) * 8;

int endtimePay = (4+24 - 24) * 16;

totalPay = endtimePay + bedtimePay + startPay;

return totalPay;

Output from MainBabysitter 

Total Night Pay: $144

# BabysitterTest

BabysitterTest is a JUnit test case used to test the functionality of the Babysitter.java class.<br>

The tests were built using Maven as the build tool and Eclipse as the IDE. <br>
The following libraries are required:<br>

JRE System Library [JavaSE - 1.8]<br>
* resources.jar<br>
* rt.jar<br>
* jsse.jar<br>
* jce.jar<br>
* charsets.jar<br>
* jfr.jar<br>
* access-bridge-64.jar<br>
* cldrdata.jar<br>
* dnsns.jar<br>
* jaccess.jar<br>
* jfxrt.jar<br>
* localedata.jar<br>
* nashorn.jar<br>
* sunec.jar<br>
* sunjce_provider.jar<br>
* sunmscapi.jar<br>
* sunpkcs11.jar<br>
* zipfs.jar<br>

JUnit 4<br>
* junit.jar<br>
* org.j=hamcrest.core_1.3.0.v201303031735.jar<br>
 
# Methods:
@Before

	public void setUp() {
		babysitter = new Babysitter();
	}
The Before method creates a new object of the Babysitter class. This method must be created to run multiple tests without created a new object for each test. 

@Test 

	public void whenStartingAt5pmAndBedtimeIs10pmAndLeaveAt4amCalculateTotalPay() {
		assertEquals(140, babysitter.calcTotalPay(17, 4, 22));
	}
	
Test method that sets start to 5pm(17), bedtime to 10pm(22), and end to 4am(4). Checks to see that the method returns 140.

@Test

	public void whenStartingAt5pmBedtimeIs9pmLeaveAtMidnight() {
		assertEquals(72, babysitter.calcTotalPay(17, 24, 21));
	}
	
Test method that sets the start to 5pm(17), bedtime to 9pm(21), and end at midnight(24). Checks to see that the method returns 72.

@Test

	public void whenStartingAt6pmAndLeavingAt9pmNoBedtime() {
		assertEquals(36, babysitter.calcTotalPay(18, 21, 0));
	}
	
Test method that sets the start to 6pm(18), there is no bedtime(0), and end at 9pm(21). Checks to see that the method returns 36.

@Test

	public void whenStartingAt5pmAndLeaveAt4amNoBedtime() {
		assertEquals(148, babysitter.calcTotalPay(17, 4, 0));
	}
	
Test method that sets the start to 5pm(17), there is no bedtime(0), and endtime is 4am(4). Checks to see that the method returns 148.

@Test

	public void tryAndCatchExceptionStartingBefore5pm() throws Exception {
		try {
			babysitter.calcTotalPay(12, 4, 22);
		}
		catch(Exception e) {
			System.out.println("Babysitter can't start before 5pm");
		}
	}
	
Test method that checks the tests the try/catch exception in the function calcTotalPay(). When the test method trys start 12pm(12), bedtime 10pm(22), and end 4am(4) the method catches the exception and outputs "Babysitter can't start before 5pm".

@Test

	public void tryandCatchExceptionStayingAfter4am() throws Exception {
		try {
			babysitter.calcTotalPay(17, 7, 22);
		}
		catch(Exception e) {
			System.out.println("Babysitter can't stay after 4am");
		}
	}

Test method that checks the tests another try/catch exception in the function calcTotalPay(). When the test method trys start<br> at 5pm(17), bedtime 10pm(22), and end 7am(7) the method catches the exception and outputs "Babysitter can't stay after 4am".

