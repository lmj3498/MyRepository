package ch04.exam02;

public class WhileExample6 {

	public static void main(String[] args) throws Exception{
		
		boolean flag = true;
		int choice = 0;
		int money = 0;
		
		while(flag){
			if(choice != 13 && choice != 10){
				
			System.out.println("----------------");
			System.out.println("1.예금|2.출금|3.종료");
			System.out.println("----------------");
			System.out.print("선택 :");
			
			}
			
			choice = System.in.read();
			
			
				if(choice == 49){
					money += 1000;
					System.out.println("현재 금액 : "+money);
				}else if(choice == 50){
					money -= 500;
					System.out.println("현재 금액 : "+money);
				}else if(choice == 51){
					flag = false;
				}
					
			
			
			
		}
			
		
		
	}

}

/*
 ----------------
 1.예금|2.출금|3.종료
 ----------------
 선택 : ~
현재 잔액 : ~원

  - 1번을 입력할 경우 1000원씩 예금을 증가시킴
  - 2번을 입력할 경우 500원씩 예금을 감소시킴
  - 3번을 입력할 경우 프로그램이 종료되도록
 */