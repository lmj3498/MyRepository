package ch12.exam10;

public class InterruptExample {

	public static void main(String[] args) {
		PrintThread2 printThread2 = new PrintThread2();
		
		printThread2.start();
		try {Thread.sleep(3000);} catch (InterruptedException e) {}
		
		printThread2.interrupt();
		
	}

}
