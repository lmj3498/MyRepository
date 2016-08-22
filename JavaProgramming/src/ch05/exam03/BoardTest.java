package ch05.exam03;

import java.util.Scanner;

public class BoardTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[][] boards = new String[100][5];//번호0, 제목1, 글쓴이2, (내용)3, 조회수4 
		
		//System.out.println(boards[0][0]);
		/*for(int i = 0;i<boards.length;i++){
			boards[i][0] = String.valueOf(i);
		}*/
			
		
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
					if(board[0]!=null){
						System.out.println(board[0]+"\t\t"+board[1]+"\t\t"+board[2]+"\t\t"+board[4]);
					}else
						break;
				}
			}else if(choice.equals("2")){
				for(int i = 0;i<boards.length;i++){
					if(boards[i] != null){
						boards[i][0] = String.valueOf(i);
						String title = null;
						String author = null;
						String content = null;
						System.out.print("제목 : ");
						title = scanner.nextLine();
						System.out.print("글쓴이 : ");
						author = scanner.nextLine();
						System.out.print("내용 : ");
						content = scanner.nextLine();
						boards[i][1] = title;
						boards[i][2] = author;
						boards[i][3] = content;
						boards[i][4] = String.valueOf(0);
						break;
					}
				}
				//여기부터 일단 수정!
			}else if(choice.equals("3")){
				System.out.print("자세히 보고 싶은 책의 번호 : ");
				String bnum = String.valueOf(scanner.nextInt());
				for(String[] board : boards){
					if(board[0]==bnum){
						System.out.println("책 제목 : "+board[1]);
						System.out.println("책 내용 : "+board[3]);
						int hitNum = Integer.parseInt(board[4]);
						hitNum++;
						board[4] = String.valueOf(hitNum);
					}
				}
			}else if(choice.equals("4")){
				System.out.print("수정하고 싶은 책의 번호 : ");
				String bnum = String.valueOf(scanner.nextInt());
				for(String[] board : boards){
					if(board[0]==bnum){
						String content = null;
						System.out.print("내용 : ");
						content = scanner.nextLine();
						board[3] = content;
					}
				}
			}else if(choice.equals("5")){
				System.out.print("삭제하고 싶은 책의 번호 : ");
				int bnum = scanner.nextInt();
				for(String[] board : boards){
					if(board[0]==String.valueOf(bnum)){
						boards[bnum] = null;
						
					}
				}
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