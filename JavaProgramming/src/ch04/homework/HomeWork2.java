package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		int num1,num2;
		int sum = 0;
		
		for(int i=1;i<=100;i++){
			num1 = (int)(Math.random()*10)+1;
			num2 = (int)(Math.random()*10)+1;
			sum=(4*num1)+(5*num2);
			if(sum == 60){
				System.out.println("("+num1+","+num2+")");
			}
		}

	}

}
/*2) 4x+5y = 60;
x의 범위는 1부터 10 사이의 정수
y는 범위는 1부터 10 사이의 정수

x가 5이면 y는 8 이고 이를 출력     


패키지명 : ch04.homework.HomeWork2*/