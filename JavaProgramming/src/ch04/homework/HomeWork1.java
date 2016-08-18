package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {
		int dice1 = 0;//주사위1변수
		int dice2 = 0;//주사위2변수
		int sum = 0;//주사위 1,2의 합을 저장하기 위한 변수
		for(int i=0;i<100;i++){//100번도는 for문
			dice1 = (int)(Math.random()*6)+1;//1~6까지의 수를 주사위1 변수에 담음
			dice2 = (int)(Math.random()*6)+1;//1~6까지의 수를 주사위2 변수에 담음
			sum=dice1+dice2;
			if(sum == 10){//주사위1,2의 합이 10인 경우 주사위 숫자들을 출력하는 조건문
				System.out.println("("+dice1+","+dice2+")");
			}
		}
		

	}

}

/*1) 주사위 2개를 100번 던집니다.
두 주사위의 눈의 합이 10이 될 때
"(주사위 1눈, 주사위2눈)"으로 출력하세요

(5,5)
(6,4)
(4,6)
...

패키지명 : ch04.homework.HomeWork1*/