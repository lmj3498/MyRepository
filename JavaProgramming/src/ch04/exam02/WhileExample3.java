package ch04.exam02;

public class WhileExample3 {

	public static void main(String[] args) throws Exception{
		System.out.println("포르그램 시작");
		int num = 0;
		while(num != 113){
			
			num = System.in.read();
			if(num != 13 && num != 10){
				System.out.println(num);
				//System.out.print("숫자를 입력하세요: ");	
			}else if(num == 113){
				break;
			} 
			
		}
		System.out.println("포르그램 종료");
	}
}
