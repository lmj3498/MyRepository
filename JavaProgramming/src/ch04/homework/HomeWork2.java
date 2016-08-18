package ch04.homework;

public class HomeWork2 {

	public static void main(String[] args) {
		//int num1,num2;
		//int sum = 0;
		
		//주어진 문제 해석1의 경우(이중 for문을 안쓰고자 했음)
		for(int i=1;i<=10;i++){//1~10까지의 x범위에 대한 for문
			if((60-4*i)%5 ==0){//4x+5y = 60 가 성립하기 위한 조건문
				System.out.println("("+i+","+(60-4*i)/5+")");//x에 대한 값인 i와 성립된 식의 y값인 (60-4*i)/5의 몫을 출력함
			}
		}
		
		//이중포문을 쓴경우
		/*for(int i=1;i<=10;i++){//1~10까지의 x범위에 대한 for문
			for(int j=1;j<=10;j++){//1~10까지의 y범위에 대한 for문
				if((4*i)+(5*j) == 60){//4x+5y = 60를 만족하는 숫자1,2를 출력하는 조건문
					System.out.println("("+i+","+j+")");
				}
			}
		}*/
		
		//주어진 문제 해석2(랜덤이라는 뜻)의 경우
		/*for(int i=1;i<=100;i++){//100번이라는 임의의 횟수 
			num1 = (int)(Math.random()*10)+1;//1~10범위의 랜덤 숫자를 숫자1에 담음
			num2 = (int)(Math.random()*10)+1;//1~10범위의 랜덤 숫자를 숫자2에 담음
			sum=(4*num1)+(5*num2); //4x+5y에 대한 연삽을 구함
			if(sum == 60){//4x+5y = 60를 만족하는 숫자1,2를 출력하는 조건문
				System.out.println("("+num1+","+num2+")");
			}
		}*/

	}

}
/*2) 4x+5y = 60;
x의 범위는 1부터 10 사이의 정수
y는 범위는 1부터 10 사이의 정수

x가 5이면 y는 8 이고 이를 출력     


패키지명 : ch04.homework.HomeWork2*/