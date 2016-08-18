package ch04.exam02;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		double avg = 0;
		for(int i=1;i<=3;i++){
			//sum = sum + i;
			/*if(0==(i%2)){
				sum += i;
			}*/
			sum += (int)(Math.random()*6)+1;
			//System.out.println(i+"번째 주사위 눈 : "+sum);
			avg = (double)sum/i;
		}
		System.out.println("3번 굴린 주사위 값의 총 합: "+sum);
		System.out.println("3번 굴린 주사위 값의 총 평균 : "+avg);
		
	}

}
