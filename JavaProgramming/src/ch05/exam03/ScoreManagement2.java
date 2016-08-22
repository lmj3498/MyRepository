package ch05.exam03;

import java.util.Scanner;

public class ScoreManagement2 {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int totalNum = 0;
		String[][] students = null;
		
		while(true){
			System.out.println("----------------------------------------------------------");
			if(students == null){
				System.out.println("1.총학생수|7.종료");
			}else{
				System.out.println("1.총학생수|2.목록|3.입력|4.삭제|5.최고 점수|6.평균|7.종료");
			}
			
			System.out.println("----------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();
			
			
			if(choice.equals("1")){
				System.out.print("총학생수 : ");
				totalNum = Integer.parseInt(scanner.nextLine());
				students = new String[totalNum][];
			}else if(choice.equals("2")){
				System.out.println("********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("********************************************");
				//if(students != null){
					for(String[] arr : students){
						if(arr != null){
							System.out.println(arr[0]+"\t\t"+arr[1]+"\t\t"+arr[2]);
						}
					}
				//}
				
			}else if(choice.equals("3")){
				System.out.print("학생이름 : ");
				String name = scanner.nextLine();
				System.out.print("점수 : ");
				String score = scanner.nextLine();
				for(int i=0;i<students.length;i++){
					if(students[i] == null){
						String[] student = {String.valueOf(i),name,score};
						students[i] = student;
						break;
					}
				}
				
				//System.out.println(" : ");
			}else if(choice.equals("4")){
				System.out.print("삭제하고자 하는 학번 : ");
				//int sno = Integer.parseInt(scanner.nextLine());
				//students[sno] = null;
				String delNum = scanner.nextLine();
				for(int i=0;i<students.length;i++){
					if(students[i][0].equals(delNum)){
						students[i] = null;
					}
				}
			}else if(choice.equals("5")){
				int max = 0;
				for(int i=0;i<students.length;i++){
					if(students != null){
						if(max<Integer.parseInt(students[i][2])){
							max = Integer.parseInt(students[i][2]);
						}
					}
				}
				for(String[] student : students){
					if(student[0] != null){
						if(max == Integer.parseInt(student[2])){
							System.out.println("********************************************");
							System.out.println("학번\t\t이름\t\t점수");
							System.out.println("********************************************");
							System.out.println(student[0]+"\t\t"+student[1]+"\t\t"+student[2]);
						}
					}
				}
				
			}else if(choice.equals("6")){
				int count = 0;
				int sum = 0;
				for(String[] student : students){
					if(student != null){
						count++;
						sum += Integer.parseInt(student[2]);
					}	
				}
				System.out.println("전체 평균 : "+ (double)sum/count);
			}else if(choice.equals("7")){
				break;
			}
		}
	}
}



/*
 숙제
게시물 수는 100
목록(번호 제목 글쓴이 조회수), 글쓰기, 상세보기, 수정하기, 삭제하기, 종료
+상세보기 일 때 내용나오고, 조회수++
내일 오전 9시까지 

 */
