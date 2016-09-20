package ch18.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class InputStreamExample2 {

	public static void main(String[] args) throws IOException {
		String filePath = InputStreamExample2.class.getResource("data.txt").getPath();
		// System.out.println(filePath);

		int count = 0;
		InputStream is = new FileInputStream(filePath);
		byte[] values = new byte[3];
		while (true) {
			
			int byteNum = is.read(values);
			if(byteNum == -1) break;
			System.out.println("읽은 데이터 수 : "+ byteNum + "  읽은 값 : "+Arrays.toString(values));
			count++;
		}
		System.out.println();
		System.out.println("읽은 횟수 : "+count);
		is.close();
		
		
		System.out.println();

		
		count = 0;
		is = new FileInputStream(filePath);
		values = new byte[3];
		int byteNum = -1;
		while ((byteNum = is.read(values)) != -1) {
			
			System.out.println("읽은 데이터 수 : "+ byteNum + "  읽은 값 : "+Arrays.toString(values));
			count++;
		}
		System.out.println();
		System.out.println("읽은 횟수 : "+count);
		is.close();
		
		
		System.out.println();
		
	}

}
