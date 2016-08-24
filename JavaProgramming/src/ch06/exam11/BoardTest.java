package ch06.exam11;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] boards = new String[100][];//번호0, 제목1, 글쓴이2, (내용)3, 조회수4 
		
		while(true){
			System.out.println("----------------------------------------------------------");
			System.out.println("1.목록|2.글쓰기|3.상세보기|4.수정하기|5.삭제하기|6.종료");
			System.out.println("----------------------------------------------------------");
			System.out.print("선택 : ");
			String choice = scanner.nextLine();
			
			if(choice.equals("1")){
				System.out.println("*******************************************************");
				System.out.println("번호\t\t제목\t\t글쓴이\t\t조회수");
				System.out.println("*******************************************************");
				for(String[] board : boards){
					if(board != null){
						System.out.println(board[0]+"\t\t"+board[1]+"\t\t"+board[2]+"\t\t"+board[4]);
					}
				}
			}else if(choice.equals("2")){
				for(int i = 0;i<boards.length;i++){
					if(boards[i] == null){
						
						System.out.print("제목 : ");
						String title = scanner.nextLine();
						System.out.print("글쓴이 : ");
						String author = scanner.nextLine();
						System.out.print("내용 : ");
						String content = scanner.nextLine();
						String[] temp = {String.valueOf(i),title,author,content,String.valueOf(0)};
						boards[i] = temp;
						break;
					}
				}
				
			}else if(choice.equals("3")){
				System.out.print("자세히 보고 싶은 책의 번호 : ");
				int bnum = Integer.parseInt(scanner.nextLine());
				System.out.println("책 제목 : "+boards[bnum][1]);
				System.out.println("책 내용 : "+boards[bnum][3]);
				int hitNum = Integer.parseInt(boards[bnum][4]);
				hitNum++;
				boards[bnum][4] = String.valueOf(hitNum);
				//여기부터 일단 수정!
			}else if(choice.equals("4")){
				System.out.print("수정하고 싶은 책의 번호 : ");
				int bnum = Integer.parseInt(scanner.nextLine());
				String content = null;
				System.out.print("바꿀내용 : ");
				content = scanner.nextLine();
				boards[bnum][3] = content;
			}else if(choice.equals("5")){
				System.out.print("삭제하고 싶은 책의 번호 : ");
				int bnum = Integer.parseInt(scanner.nextLine());
				boards[bnum] = null;
				
			}else if(choice.equals("6")){
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