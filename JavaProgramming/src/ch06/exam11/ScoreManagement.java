package ch06.exam11;

import java.util.Scanner;

public class ScoreManagement {

	public static void main(String[] args) throws Exception{
		Scanner scanner = new Scanner(System.in);
		int totalNum = 0;
		Student[] students = null;
		
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
				students = new Student[totalNum];
			}else if(choice.equals("2")){
				System.out.println("********************************************");
				System.out.println("학번\t\t이름\t\t점수");
				System.out.println("********************************************");
				//if(students != null){
					for(Student arr : students){
						//Student student = arr;//이부분 보통 for문으로 고쳐서 해야될 듯
						if(arr != null){
							System.out.println(arr.no+"\t\t"+arr.name+"\t\t"+arr.score);
						}
					}
				//}
				
			}else if(choice.equals("3")){
				System.out.print("학생이름 : ");
				String name = scanner.nextLine();
				System.out.print("점수 : ");
				int score = Integer.parseInt(scanner.nextLine());
				
				for(int i=0;i<students.length;i++){
					if(students[i] == null){//여기서 만약 에러나면 Student student로 해서 받고 이걸 옮김
						students[i] = new Student(i, name,score);
						break;
					}
				}
				
				//System.out.println(" : ");
			}else if(choice.equals("4")){
				System.out.print("삭제하고자 하는 학번 : ");
				int sno = Integer.parseInt(scanner.nextLine());
				students[sno] = null;
			}else if(choice.equals("5")){
				int max = 0;
				for(int i=0;i<students.length;i++){
					if(students != null){
						int score = students[i].score;
						if(max<score){
							max = score;
						}
					}
				}
				for(Student student : students){
					if(student != null){
						if(max == student.score){
							System.out.println("********************************************");
							System.out.println("학번\t\t이름\t\t점수");
							System.out.println("********************************************");
							System.out.println(student.no+"\t\t"+student.name+"\t\t"+student.score);
						}
					}
				}
				
			}else if(choice.equals("6")){
				int count = 0;
				int sum = 0;
				for(Student student : students){
					if(student != null){
						count++;
						sum += student.score;
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
