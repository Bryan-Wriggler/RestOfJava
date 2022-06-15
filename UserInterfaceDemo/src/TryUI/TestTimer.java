package TryUI;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestTimer {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean isTrue = false; //this will test periodically if it is true, if it's false, then keep running
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(0); //test schedule executor service
		
		Runnable command = null;
		executor.scheduleWithFixedDelay(command, 1, 1, TimeUnit.SECONDS); //test if it'll delay every 1 second
		
		//not done yet, maybe try to test it at home
		in.close();
	}
}
