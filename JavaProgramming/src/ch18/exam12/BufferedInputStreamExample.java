package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamExample {

	public static void main(String[] args) throws IOException {

		long start = 0;
		long end = 0;

		//일반 인풋스트림
		FileInputStream fis = new FileInputStream("src/ch18/exam12/12345.jpg");

		start = System.currentTimeMillis();
		while (fis.read() != -1) {

		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		//성능 향상을 위한 보조 스트림
		FileInputStream fis2 = new FileInputStream("src/ch18/exam12/12345.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		
		start = System.currentTimeMillis();
		while (bis.read() != -1) {

		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
