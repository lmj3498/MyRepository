package ch12.exam08;

public class WaitNotifyExample2 {

	public static void main(String[] args) {
		DataBox dataBox = new DataBox();
		
		ProducerThread producerThread = new ProducerThread(dataBox);
		ConsumerThread concumerThread = new ConsumerThread(dataBox);
		
		producerThread.start();
		concumerThread.start();

	}

}
