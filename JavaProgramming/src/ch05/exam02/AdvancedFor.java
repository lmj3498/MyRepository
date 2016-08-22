package ch05.exam02;

public class AdvancedFor {

	public static void main(String[] args) {
		int[] scores = {90, 92, 95};
		
		int sum = 0;
		/*for(int i = 0;i<scores.length;i++){
			sum += scores[i];
		}*/
		
		//향상된 for문
		for(int score : scores){
			sum += score;
		}
		System.out.println(sum);

		
		String[] names = {"자바", "c언어","파이썬"};
		
		/*for(int i = 0;i<names.length;i++){
			System.out.println(names[i]);
		}*/
		
		//향상된 for문
		for( String name : names){
			System.out.println(name);
		}
		
		
	}

}
