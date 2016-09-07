package ch12.exam09;

public class StopFlagExample {

	public static void main(String[] args) {
		PrintThread1 printThread1 = new PrintThread1();
		
		printThread1.start();
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		
		printThread1.setStop(true);
		
	}

}
