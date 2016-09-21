package ch18.exam11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;

public class InputStreamReaderExample {

	public static void main(String[] args) throws IOException {
		
		InputStream is = System.in;
		
		Reader reader = new InputStreamReader(is);

		char data = (char) reader.read();
		System.out.println(data);
		
	
	}

}
