package ch04.homework;

public class HomeWork1 {

	public static void main(String[] args) {
		int dice1 = 0;
		int dice2 = 0;
		int sum = 0;
		for(int i=0;i<100;i++){
			dice1 = (int)(Math.random()*6)+1;
			dice2 = (int)(Math.random()*6)+1;
			sum=dice1+dice2;
			if(sum == 10){
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