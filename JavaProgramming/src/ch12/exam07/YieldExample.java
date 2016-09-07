package ch12.exam07;

public class YieldExample {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		threadA.work = Work.PAUSE;

		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		threadA.work = Work.CONTINUE;
		
		try {Thread.sleep(3000);} catch (InterruptedException e) {e.printStackTrace();}
		//threadA.stop();
		//threadB.stop();
		threadA.stop = true;
		threadB.stop = true;
		
	}

}
