package ch05.exam03;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) throws Exception{
		
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수 : ");
		String strNum = scanner.nextLine();
		int num = Integer.parseInt(strNum);
		
		int[] scores = new int[num];
		for(int i = 0 ;i<scores.length;i++){
			//int data = System.in.read();
			//System.out.println(data);
			
			//int value1 = scanner.nextInt();
			//String value2 = scanner.nextLine();
			//System.out.println(value1);
			//System.out.println(value2);
			System.out.print("점수 : ");
			String data = scanner.nextLine();
			int score = Integer.parseInt(data);
			System.out.println(score);
			scores[i] = score;
			
		}
		int sum = 0;
		for(int score : scores){
			sum += score;
		}
		
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+(double)sum/scores.length);
	}

}
