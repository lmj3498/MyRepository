package ch12.exam08;

public class WorkObject {
	public synchronized void methodA(){
		System.out.println("ThreadA의 methodA()작업 싫행");
		notify();
		try {wait();} catch (InterruptedException e) {}
	}
	
	public synchronized void methodB(){
		System.out.println("ThreadB의 methodB()작업 싫행");
		notify();
		try {wait();} catch (InterruptedException e) {}
	}
}
