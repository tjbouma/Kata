# Babysitter
This kata simulates a babysitter working and getting paid for one night. The rules are pretty straight forward:

The babysitter

starts no earlier than 5:00PM
leaves no later than 4:00AM
gets paid $12/hour from start-time to bedtime
gets paid $8/hour from bedtime to midnight
gets paid $16/hour from midnight to end of job
gets paid for full hours (no fractional hours)
Feature: As a babysitter In order to get paid for 1 night of work I want to calculate my nightly charge

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
