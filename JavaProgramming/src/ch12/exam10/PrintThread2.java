package ch12.exam10;

public class PrintThread2 extends Thread{
	
	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		try {
			while(true){
				System.out.println("실행 중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		System.out.println("자원 정리");
		System.out.println("실행 종료");
		
	}
	
}
