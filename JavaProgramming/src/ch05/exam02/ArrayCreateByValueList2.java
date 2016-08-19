package ch05.exam02;

public class ArrayCreateByValueList2 {

	public static void main(String[] args) {
		//방법1
		int[] scores = {83,90,87};
		
		
		int arrayLength = scores.length;
		System.out.println("배열의 길이는 : "+arrayLength);
		
		for(int i=0;i<scores.length;i++){
			System.out.println(scores[i]);
		}
		
		int sum=0;
		double avg = 0;
		for(int i=0;i<scores.length;i++){
			sum += scores[i];
		}
		System.out.println("전체 합 : "+sum);
		avg = (double)sum/scores.length;//avg = 1.0*sum/scores.length;
		System.out.println("전체 평균 : "+avg);
		
	}
}
