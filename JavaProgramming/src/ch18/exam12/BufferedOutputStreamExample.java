package ch18.exam12;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {

	public static void main(String[] args) throws IOException {
		
		long start = 0;
		long end = 0;
		//--------------------------------------------------------------
		FileInputStream fis = new FileInputStream("src/ch18/exam10/12345.jpg");
		FileOutputStream fos = new FileOutputStream("src/ch18/exam10/12345_2.jpg");
		
		int value;
		
		start = System.currentTimeMillis();
		while((value = fis.read())!=-1){
			fos.write(value);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		fos.flush();
		fos.close();
		fis.close();
		
		//--------------------------------------------------------------
		
		
		FileInputStream fis2 = new FileInputStream("src/ch18/exam10/12345.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2);
		FileOutputStream fos2 = new FileOutputStream("src/ch18/exam10/12345_2.jpg");
		BufferedOutputStream bos = new BufferedOutputStream(fos2);
		
		int value2;
		
		start = System.currentTimeMillis();
		while((value2 = bis.read())!=-1){
			bos.write(value2);
		}
		end = System.currentTimeMillis();
		System.out.println(end - start);
		
		
		bos.flush();
		bos.close();
		bis.close();
		
		fis2.close();
		fos2.close();
	}

}
