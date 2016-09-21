package ch18.exam12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException {

		long start = 0;
		long end = 0;

		//일반 인풋스트림
		FileReader fr = new FileReader("src/ch18/exam12/NAVER.html");

		start = System.currentTimeMillis();
		while (fr.read() != -1) {

		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		//성능 향상을 위한 보조 스트림
		FileReader fr2 = new FileReader("src/ch18/exam12/NAVER.html");
		BufferedReader bfr = new BufferedReader(fr2);
		
		start = System.currentTimeMillis();
		while (bfr.read() != -1) {

		}
		end = System.currentTimeMillis();
		System.out.println(end - start);

	}

}
