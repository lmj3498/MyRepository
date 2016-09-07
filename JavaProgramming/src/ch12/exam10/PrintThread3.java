package ch12.exam10;

public class PrintThread3 extends Thread {

	private boolean stop;

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	@Override
	public void run() {

		while (true) {
			System.out.println("실행중...");
			//if (isInterrupted()) {
				if(Thread.interrupted()){
				break;

			}

			System.out.println("자원 정리");
			System.out.println("실행 종료");
		}
	}

}
