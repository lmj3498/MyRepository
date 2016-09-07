package ch12.exam08;

public class WaitNotifyExample {

	public static void main(String[] args) {
		WorkObject shardObject = new WorkObject();
		
		ThreadA threadA = new ThreadA(shardObject);
		ThreadB threadB = new ThreadB(shardObject);
		
		threadA.start();
		threadB.start();
		

	}

}
