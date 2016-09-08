package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteServiceExample {

	public static void main(String[] args) {
		//쓰레드 풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		//작업 생성
		Runnable task = new Runnable(){
			@Override
			public void run() {
				
				for(int i=0;i<10;i++){
					System.out.println("실행 중... " + i + Thread.currentThread().getName());
				}
			}
		};
		
		//작업 큐에 작업 넣기
		executorService.submit(task);
		
		//스레드풀 종료
		executorService.shutdown();

	}

}
