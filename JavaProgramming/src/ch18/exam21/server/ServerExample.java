package ch18.exam21.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	// 서버소켓 생성
	private static ServerSocket serverSocket;
	private static boolean stop;

	public static void main(String[] args) {

		System.out.println("[서버 시작]");

		try {
			// 서버의 어떤 IP라도 접근할 수 있도록 한 것
			serverSocket = new ServerSocket(5001);

			Thread thread = new Thread() {

				@Override
				public void run() {
					waitAndAccept();

				}
			};
			thread.start();

			// 클라이언트의 연결을 수락하고 통신용 위한 Socket을 생성

		} catch (IOException e) {
			e.printStackTrace();
		}

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("명령어 입력 : ");
			String command = scanner.nextLine();
			if (command.equals("stop")) {
				stop = true;// 작업 스레드(클라이언트의 연결 수락을 중지)
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("[서버 종료]");
				System.exit(0);// 서버 Process를 종료
			}
		}

	}

	private static void waitAndAccept() {
		try {
			while (!stop) {
				Socket socket = null;
				for (int i = 0; i < 10; i++) {
					// 클라이언트의 연결을 수락하고 통신용 Socket을 생성

					socket = serverSocket.accept();
					try {
						// 클라이언트에서 보낸 데이터를 읽기
						InputStream is = socket.getInputStream();
						byte[] receiveValues = new byte[1024];
						int byteNum = is.read(receiveValues);
						if(byteNum != -1){
							String data = new String(receiveValues, 0, byteNum, "UTF-8");

							// 클라이언트로 에코 보내기
							OutputStream os = socket.getOutputStream();
							byte[] sendValues = data.getBytes("UTF-8");
							os.write(sendValues);
							os.flush();
						}else{
							System.out.println("[클라이언트 정상 종료]");
						}
						
						// 클라이언트의 연결을 끊음
						socket.close();
					} catch (Exception e) {
						System.out.println("[클라이언트 비정상 종료]");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
