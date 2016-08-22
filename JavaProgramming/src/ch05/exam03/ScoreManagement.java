package ch05.exam03;

import java.util.Scanner;

public class ScoreManagement {

	public static void main(String[] args) throws Exception{
		
		//이하 내용은 되게 좋은 예제임 
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("학생수 : ");
		String strNum = scanner.nextLine();
		int num = Integer.parseInt(strNum);
		String[][] scores = new String[num][2];
		
		for(int i = 0 ;i<scores.length;i++){
			System.out.print("이름 : ");
			String name = scanner.nextLine();
			System.out.print("점수 : ");
			String score = scanner.nextLine();
			String[] arr = {name, score};
			scores[i] =arr;
		}
		while(true){
			System.out.println("-------------------");
			System.out.println("1.최고 점수|2.평균|3.종료");
			System.out.println("-------------------");
			
			System.out.print("선택 : ");
			//int choiceNum = Integer.parseInt(scanner.nextLine());
			String choiceNum = scanner.nextLine();//문자열로 비교하기 위해
			if(choiceNum.equals("1")){
				System.out.println("최고 점수 선택");
			}else if(choiceNum.equals("2")){
				System.out.println("평균 선택");
			}else if(choiceNum.equals("3")){
				break;
			}
		}
		
	}

}
