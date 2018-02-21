package pillar;

import java.util.Scanner;


public class MainBabysitter {
	
	public static void main(String [] args) throws Exception {
		Babysitter babysitter = new Babysitter();
		
		Scanner reader = new Scanner(System.in);
		
		System.out.println("Time should be rounded down to the closest hour. For example 5:35pm should be 17.\nEnter start time using 24hr clock: ");
		int start = reader.nextInt();
		
		System.out.println("Time should be rounded up to the closest hour. For example 10:27pm should be 23.\nIf the child does not go to bed enter 0. \nEnter bedtime using 24 hr clock: ");
		int bedtime = reader.nextInt();
		
		System.out.println("Time should be rounded up to the closest hour. For example 3:37am should be 4.\nEnter endtime using 24 hr clock: ");
		int endtime = reader.nextInt();
		
		int totalPay = babysitter.calcTotalPay(start,endtime,bedtime);
		System.out.printf("Total Night Pay: $%d%n", totalPay);
		
		reader.close();
	}
}
