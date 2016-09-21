package ch18.exam08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class ScannerExample2 {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		InputStream is = new FileInputStream("src/ch18/exam08/data.txt");
		
		Scanner scanner2 = new Scanner(is);
		String name = scanner2.nextLine();
		int age = Integer.parseInt(scanner2.nextLine());
		double height = Double.parseDouble(scanner2.nextLine());
		
		
		
		Scanner scanner1 = new Scanner(System.in);
		
		/*System.out.print("이름 : ");
		String name = scanner1.nextLine();

		
		System.out.print("나이 : ");
		int age = scanner1.nextInt();

		System.out.print("키 : ");
		double height = scanner1.nextDouble();
	*/		
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
	
	}

}
