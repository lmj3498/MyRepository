package ch12.exam14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteServiceExample3 {

	public static void main(String[] args) {
		// 쓰레드 풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(5);

		// 작업 생성
		for (int i = 0; i < 10; i++) {
			int count = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					System.out.println("스레드의 총수 : " + threadPoolExecutor.getPoolSize());

					System.out.println(count + "   실행 중...   " + Thread.currentThread().getName());
					int value = Integer.parseInt("aa");//NumberFormatException 발생
				}
			};

			// 작업 큐에 작업 넣기
			executorService.submit(task);
			//executorService.execute(task);

		}

		// 스레드풀 종료
		executorService.shutdown();

	}

}
